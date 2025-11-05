(ns todo.todo
  (:require
   [xtdb.api :as xt]
   [hiccup.core :refer [html]]
   [hiccup.page :refer [html5 include-js include-css]]
   [ring.util.response :as resp]
   [ring.middleware.anti-forgery :as csrf]
   [todo.ui :as ui]
   [clojure.string :as str]
   [clojure.pprint :refer [pprint]])) ;; biff utilities, if provided by your starter

;; -------------------------
;; DB helpers (XTDB)
;; -------------------------
(defn xt-node [ctx]
  ;; Biff typically puts the XTDB node on the ctx under :biff/xtdb-node
  (or (:biff.xtdb/node ctx)
      (:biff/xtdb-node ctx)
      (:xtdb/node ctx) ;; fallback if different
      (throw (ex-info "XT node not found in ctx" {}))))

(defn now [] (java.util.Date.))

(defn create-todo! [ctx title]
  (let [node (xt-node ctx)
        id   (java.util.UUID/randomUUID)
        doc  {:xt/id id
              :todo/id id
              :todo/title (str/trim (or title ""))
              :todo/done false
              :todo/created-at (now)}]
    (xt/submit-tx node [[::xt/put doc]])
    (xt/sync node)
    doc))

(defn fetch-todos [ctx]
  (let [node (xt-node ctx)
        q '{:find  [(pull ?e [*])]
            :where [[?e :todo/id]]}]
    (->> (xt/q (xt/db node) q)
         (map first)
         (sort-by :todo/created-at))))

(defn get-todo-by-id [ctx id]
  (let [node (xt-node ctx)]
    (xt/entity (xt/db node) id)))

(defn toggle-todo! [ctx id]
  (let [node (xt-node ctx)
        cur  (get-todo-by-id ctx id)
        new  (assoc cur :todo/done (not (:todo/done cur)))]
    (xt/submit-tx node [[::xt/put new]])
    (xt/sync node)
    new))

(defn delete-todo! [ctx id]
  (let [node (xt-node ctx)
        cur  (get-todo-by-id ctx id)]
    (when cur
      (xt/submit-tx node [[::xt/delete id]])
      (xt/sync node))
    nil))

;; -------------------------
;; Views (Hiccup)
;; -------------------------
(defn todo-row [todo]
  ;; Must return a DOM element whose id can be targeted by htmx swaps.
  (let [id (:todo/id todo)
        id-str (str id)
        target (str "#todo-" id-str)]
    [:div.todo-row {:id (str "todo-" id-str)}
     [:input {:type "checkbox"
              :checked (when (:todo/done todo) "checked")
              :hx-post (str "/todo/todos/" id-str "/toggle")
              :hx-swap "outerHTML"
              :hx-target (str "#todo-" id-str)
              :hx-headers (cheshire.core/generate-string
                           {:x-csrf-token csrf/*anti-forgery-token*})}]
     [:span.title {:hx-get (str "/todo/todos/" id-str "/edit")
                   :hx-target target
                   :hx-swap "outerHTML"
                   :style (when (:todo/done todo) "text-decoration:line-through; margin-left:8px; cursor:pointer;")}
      (:todo/title todo)]
     [:button {:hx-delete (str "/todo/todos/" id-str)
               :hx-swap "delete"
               :hx-target (str "#todo-" id-str)
               :style "margin-left:12px;"
               :hx-headers (cheshire.core/generate-string
                            {:x-csrf-token csrf/*anti-forgery-token*})} "Delete"]]))

(defn todo-list-fragment [todos]
  ;; Render all rows (returns Hiccup; Biff will render to string)
  (into [:div#todo-list]
        (map todo-row) todos))

(defn index-page [ctx todos]
  (ui/page
   ctx
   [:h1 "Todos"]
   [:form#add-todo
    {:hx-post "/todo/todos"
     :hx-target "#todo-list"
     :hx-swap "beforeend"
     :hx-headers (cheshire.core/generate-string
                  {:x-csrf-token csrf/*anti-forgery-token*})}
    [:input {:type "text" :name "title" :placeholder "What needs to be done?" :required true
             :style "width:70%;padding:8px;margin-right:8px;"}]
    [:button {:type "submit"} "Add"]]
   (todo-list-fragment todos)))

;; -------------------------
;; Handlers (Ring-style)
;; -------------------------
(defn handle-index [ctx]
  (println "xt ctx bhanu:" (keys ctx))
  (let [todos (fetch-todos ctx)]
    (-> (resp/response (html (index-page ctx todos)))
        (resp/content-type "text/html; charset=utf-8"))))

(defn handle-create [ctx]
  (println "---------- CTX START ----------")
  (clojure.pprint/pprint (select-keys ctx [:uri :request-method :params :form-params :headers]))
  (println "---------- CTX END ----------")

  (let [title (-> ctx :params :title)]
    (println "create:bhanu params ->" (:params ctx))
    (if (str/blank? title)
      (-> (resp/response "Title required") (resp/status 422))
      (let [todo (create-todo! ctx title)]
        (-> (resp/response (html (todo-row todo)))
            (resp/content-type "text/html; charset=utf-8"))))))

(defn handle-show [ctx]
  ;; GET /todo/todos/:id  -> return the todo-row HTML for that id
  (let [id-str (get-in ctx [:path-params :id])]
    (try
      (let [id (java.util.UUID/fromString id-str)
            todo (get-todo-by-id ctx id)]
        (if todo
          (-> (resp/response (html (todo-row todo)))
              (resp/content-type "text/html; charset=utf-8"))
          (resp/status (resp/response "Not found") 404)))
      (catch Exception _
        (resp/status (resp/response "Invalid UUID") 400)))))

(defn handle-edit [ctx]
  (let [id-str (get-in ctx [:path-params :id])]
    (try
      (let [id   (java.util.UUID/fromString id-str)
            todo (get-todo-by-id ctx id)]
        (if todo
          (let [target (str "#todo-" id-str)]
            (-> (resp/response
                 (html
                  [:form.inline-edit
                   {:hx-post (str "/todo/todos/" id-str)
                    :hx-target target
                    :hx-swap "outerHTML"}
                   [:input.inline-edit-input {:name "title"
                                              :type "text"
                                              :value (:todo/title todo)
                                              :style "width:70%;padding:6px;"
                                              :autofocus true}]
                   [:button.btn {:type "submit"} "Save"]
                   [:button.btn {:type "button"
                                 :hx-get (str "/todo/todos/" id-str)
                                 :hx-target target
                                 :hx-swap "outerHTML"} "Cancel"]]))
                (resp/content-type "text/html; charset=utf-8")))
          (resp/status (resp/response "Not found") 404)))
      (catch Exception e
        (resp/status (resp/response "Invalid UUID") 400)))))

(defn handle-update [ctx]
  (println "bhanu")
  ;; PUT /todo/todos/:id -> update title, return updated todo-row
  (let [id-str (get-in ctx [:path-params :id])]
    (try
      (let [id (java.util.UUID/fromString id-str)
            title (-> ctx :form-params (get "title"))]
        (println "handle-update ctx keys:" (keys ctx))
        (println "handle-update form-params:" (:form-params ctx))
        (println "handle-update title:" title)
        (if (str/blank? title)
          (resp/status (resp/response "Title required") 422)
          (let [todo (get-todo-by-id ctx id)]
            (if-not todo
              (resp/status (resp/response "Not found") 404)
              (let [updated (assoc todo :todo/title (str/trim title))
                    node (xt-node ctx)]
                (xt/submit-tx node [[::xt/put updated]])
                (xt/sync node)
                (-> (resp/response (html (todo-row updated)))
                    (resp/content-type "text/html; charset=utf-8")))))))
      (catch Exception e
        (resp/status (resp/response "Invalid UUID") 400)))))

(defn handle-toggle [ctx]
  (prn "CTX params:" (:path-params ctx))
  (prn "CTX path-params:" (get-in ctx [:biff/req :path-params]))
  (let [id-str (get-in ctx [:path-params :id])]
    (if (str/blank? id-str)
      (resp/status (resp/response "Missing ID") 400)
      (try
        (let [id (java.util.UUID/fromString id-str)
              todo (toggle-todo! ctx id)]
          (if todo
            (-> (resp/response (html (todo-row todo)))
                (resp/content-type "text/html; charset=utf-8"))
            (resp/status (resp/response "Todo not found") 404)))
        (catch Exception _
          (resp/status (resp/response "Invalid UUID") 400))))))

(defn handle-delete [ctx]
  (let [id-str (get-in ctx [:path-params :id])]
    (if (str/blank? id-str)
      (resp/status (resp/response "Missing ID") 400)
      (try
        (let [id (java.util.UUID/fromString id-str)]
          (delete-todo! ctx id)
          (-> (resp/response "OK") (resp/status 200)))
        (catch Exception _
          (resp/status (resp/response "Invalid UUID") 400))))))

;; -------------------------
;; Module routes for Biff
;; -------------------------
(def module
  {:routes
   [["/todo" {:get handle-index}]
    ["/todo/todos" {:post handle-create}]
    ["/todo/todos/:id/toggle" {:post handle-toggle}]
    ["/todo/todos/:id" {:get handle-show
                        :delete handle-delete
                        :post handle-update}]
    ["/todo/todos/:id/edit" {:get handle-edit}]]})
