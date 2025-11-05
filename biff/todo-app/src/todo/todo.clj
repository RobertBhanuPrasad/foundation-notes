(ns todo.todo
  (:require
   [com.biffweb :as biff]
   [todo.ui :as ui])) 
   
(defonce todos (atom []))

(defn add-todo [ctx]
  (let [title (:title (:params ctx))
        id    (str (random-uuid))
        todo  {:id id :title (or title "")}]
    (println "todobhanu" todo)
    (swap! todos conj todo)
    [:li
     {:id    (str "todo-" id)
      :style {:display        "flex"
              :align-items    "center"
              :gap            "8px"
              :padding        "8px 0"
              :border-bottom  "1px solid #eee"}}
     [:span.title {:style {:flex "1" :cursor "pointer"}
                   :hx-get  (str "/todo/todos/" id)
                   :hx-target (str "#todo-" id)
                   :hx-swap "outerHTML"} (:title todo)]
    ;;  [:button#edit-button {:type "button" :class "btn" :hx-get "todo/todos" :hx-target "previous" :hx-swap "outerHTML"} "Edit"]
     [:button {:type "button" :class "btn danger" 
               :hx-target (str "#todo-" id)
               :hx-swap "delete"
               :hx-delete (str "/todo/todos/" id)} "Delete"]]))

(defn edit-todo [ctx]
  (let [id (get-in ctx [:path-params :id])
        todo (some #(when (= (:id %) id) %) @todos)]
    (if todo
      [:li
       {:id (str "todo-" id)
        :style {:display "flex" :align-items "center"
                :gap "8px" :padding "8px 0"
                :border-bottom "1px solid #eee"}}
       ;; When form submitted, PUT request updates todo
       (biff/form
        {:hx-put (str "/todo/todos/" id)
         :hx-target (str "#todo-" id)
         :hx-swap "outerHTML"}
        [:input {:type "text"
                 :name "title"
                 :value (:title todo)
                 :required true
                 :style {:flex "1"}}]
        [:button {:type "submit" :class "btn"} "Save"])]
      {:status 404 :body "Todo not found"})))

;; (defn get-label [ctx] 
;;    [:input {:type "text" :name "title" :required true :hx-put (str "/todo/todos/" id) :hx-swap "outerHTML"}])

(defn update-label [ctx]
  [:<> 
   [:input {:type "text" :name "title" :required true :hx-put "todo/todos"}]
   [:button {:type "button" :class "btn" :hx-put "todo/todos" :hx-swap-oob "true" :id "edit-button" :hx-swap "outerHTML"} "Save"]])

(defn update-todo [ctx]
  (let [id    (get-in ctx [:path-params :id])
        title (get-in ctx [:params :title])
        updated (atom nil)]
    (swap! todos
           (fn [ts]
             (mapv (fn [t]
                     (if (= (:id t) id)
                       (do
                         (reset! updated (assoc t :title title))
                         (assoc t :title title))
                       t))
                   ts)))
    (if @updated
      [:li
       {:id    (str "todo-" id)
        :style {:display        "flex"
                :align-items    "center"
                :gap            "8px"
                :padding        "8px 0"
                :border-bottom  "1px solid #eee"}}
       [:span.title {:style {:flex "1" :cursor "pointer"}
                     :hx-get "todo/todos"
                     :hx-swap "outerHTML"} (:title @updated)]
       [:button {:type "button" :class "btn danger"
                 :hx-target (str "#todo-" id)
                 :hx-swap "delete"
                 :hx-delete (str "/todo/todos/" id)} "Delete"]]
      {:status 404 :body "Todo not found"})))

(defn remove-todo [ctx]
  (let [id (get-in ctx [:path-params :id])]
    (swap! todos (fn [ts] (vec (remove #(= (:id %) id ) ts))))
  {:status 200}))

(defn all-todos [ctx]
    [:ul#todo-list
     (for [{:keys [id title]} @todos]
       ^{:key id}
       [:li
        {:id    (str "todo-" id)
         :style {:display        "flex"
                 :align-items    "center"
                 :gap            "8px"
                 :padding        "8px 0"
                 :border-bottom  "1px solid #eee"}}
        [:span.title {:style {:flex "1" :cursor "pointer"}
                      :hx-get  (str "/todo/todos/" id)
                      :hx-target (str "#todo-" id)
                      :hx-swap "outerHTML"} title]
        ;; [:button {:type "button" :class "btn"} "Edit"]
        [:button {:type "button" :class "btn danger"
                  :hx-delete (str "/todo/todos/" id)
                  :hx-swap   "delete"
                  :hx-target (str "#todo-" id)} "Delete"]])])

(defn home-page [ctx]
  (ui/page
   ctx
   [:h1 "Todos"]
   [:div
    (biff/form
     {:hx-post "/todo/todos"
      :class ""
      :hx-target "#todo-list"
      :hx-swap "beforeend"}
     [:input.p-4.bg-green-100 {:type "text" :name "title" :placeholder "Something"
                               :required true}]
     [:button.p-4.bg-blue-500 {:type "submit"} "Add"])
    (all-todos ctx)]))

(defn inputs [ctx] 
  (ui/page
   ctx
   [:div.p-2 {:hx-put "/todo/todos"}
    [:input {:type "text" :name "name" :placeholder "name"}]
    [:input {:type "text" :name "age" :placeholder "age"}]
    [:inpit {:type "text" :name "height" :placeholder "height"}]])
  )

(def module
  {:routes
   [["/todo" 
     ["" {:get home-page}]
     ["/todos" {:post add-todo
                ;; :delete remove-todo
                ;; :get update-label
                ;; :get get-label
                :put update-todo}]
     ["/todos/:id" {:get edit-todo
                    :put update-todo
                    :delete remove-todo}]
     ["/inputs" {:get inputs}]
     ]]})
