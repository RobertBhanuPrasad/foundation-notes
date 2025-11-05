(ns todo.todo
  (:require
   [com.biffweb :as biff]
   [todo.ui :as ui])) 
   
(defn add-todo [ctx]
  (let [title (:title (:params ctx))]
    [:li
     {:id    (str "todo-" (random-uuid))
      :style {:display        "flex"
              :align-items    "center"
              :gap            "8px"
              :padding        "8px 0"
              :border-bottom  "1px solid #eee"}}
     [:span.title {:style {:flex "1" :cursor "pointer"} :hx-get "todo/todos" :hx-swap "outerHTML"} title]
    ;;  [:button#edit-button {:type "button" :class "btn" :hx-get "todo/todos" :hx-target "previous" :hx-swap "outerHTML"} "Edit"]
     [:button {:type "button" :class "btn danger" 
               :hx-target "closest li"
               :hx-swap "outerHTML"
               :hx-delete "/todo/todos"} "Delete"]]))

(defn get-label [ctx] 
   [:input {:type "text" :name "title" :required true :hx-put "todo/todos" :hx-swap "outerHTML"}])

(defn update-label [ctx]
  [:<> 
   [:input {:type "text" :name "title" :required true :hx-put "todo/todos"}]
   [:button {:type "button" :class "btn" :hx-put "todo/todos" :hx-swap-oob "true" :id "edit-button" :hx-swap "outerHTML"} "Save"]])

(defn update-todo [ctx]
  (let [title (:title (:params ctx))]
    {:id    (str "todo-" (random-uuid))
     :style {:display        "flex"
             :align-items    "center"
             :gap            "8px"
             :padding        "8px 0"
             :border-bottom  "1px solid #eee"}}
    [:span.title {:style {:flex "1" :cursor "pointer"} :hx-get "todo/todos" :hx-swap "outerHTML"} title]))

(defn remove-todo [ctx] 
  {:status 200})

(defn all-todos [ctx]
  (let [todos [{:id 1 :title "Buy milk"}
               {:id 2 :title "Write report"}
               {:id 3 :title "Call Alice"}]]
    [:ul#todo-list
     (for [{:keys [id title]} todos]
       ^{:key id}
       [:li
        {:id    (str "todo-" id)
         :style {:display        "flex"
                 :align-items    "center"
                 :gap            "8px"
                 :padding        "8px 0"
                 :border-bottom  "1px solid #eee"}}
        [:span.title {:style {:flex "1" :cursor "pointer"}} title]
        ;; [:button {:type "button" :class "btn"} "Edit"]
        [:button {:type "button" :class "btn danger"} "Delete"]])]))

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
                :delete remove-todo
                ;; :get update-label
                :get get-label
                :put update-todo}]
     ["/inputs" {:get inputs}]
     ]]})
