(ns todo.todo
  (:require
   [xtdb.api :as xt]
   [hiccup.core :refer [html]]
   [hiccup.page :refer [html5 include-js include-css]]
   [ring.util.response :as resp]
   [ring.middleware.anti-forgery :as csrf]
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
  [:div.todo-row {:id (str "todo-" (:todo/id todo))}
   [:input {:type "checkbox"
            :checked (when (:todo/done todo) "checked")
            :hx-post (str "/todo/todos/" (:todo/id todo) "/toggle")
            :hx-swap "outerHTML"
            :hx-target (str "#todo-" (:todo/id todo))
            :hx-headers (cheshire.core/generate-string
                         {:x-csrf-token csrf/*anti-forgery-token*})}]
   [:span {:style (when (:todo/done todo) "text-decoration:line-through; margin-left:8px;")}
    (:todo/title todo)]
   [:button {:hx-delete (str "/todo/todos/" (:todo/id todo))
             :hx-swap "outerHTML"
             :hx-target (str "#todo-" (:todo/id todo))
             :style "margin-left:12px;"
             :hx-headers (cheshire.core/generate-string
                          {:x-csrf-token csrf/*anti-forgery-token*})} "Delete"]])

(defn todo-list-fragment [todos]
  ;; Render all rows (returns Hiccup; Biff will render to string)
  (into [:div#todo-list]
        (map todo-row) todos))

(defn index-page [ctx todos]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
    ;; your CSS produced by Tailwind
    (include-css "/css/main.css")
    ;; Load HTMX
    (include-js "https://cdn.jsdelivr.net/npm/htmx.org@1.9.12")]
   [:body
    [:div.container {:style "max-width:720px;margin:40px auto;padding:16px;"}
     [:h1 "Todos"]
     ;; Add form: hx-post to /todos and append new row to #todo-list
     [:form#add-todo
      {:hx-post "/todo/todos"
       :hx-target "#todo-list"
       :hx-swap "innerHTML"
       ;; include CSRF header
      :hx-headers (cheshire.core/generate-string
                   {:x-csrf-token csrf/*anti-forgery-token*})}
      [:input {:type "text" :name "title" :placeholder "What needs to be done?" :required true
               :style "width:70%;padding:8px;margin-right:8px;"}]
      [:button {:type "submit"} "Add"]]
     ;; container where todo rows are appended
     (todo-list-fragment todos)]]))

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
          (-> (resp/response "") (resp/status 204)))
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
    ["/todo/todos/:id" {:delete handle-delete}]]})
