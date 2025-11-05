(ns todo.schema)

(def schema
  {:user/id :uuid
   :user [:map {:closed true}
          [:xt/id                     :user/id]
          [:user/email                :string]
          [:user/first-name {:optional true} :string]
          [:user/last-name {:optional true} :string]
          [:user/joined-at            inst?]
          [:user/foo {:optional true} :string]
          [:user/bar {:optional true} :string]
          ]

   :msg/id :uuid
   :msg [:map {:closed true}
         [:xt/id       :msg/id]
         [:msg/user    :user/id]
         [:msg/text    :string]
         [:msg/sent-at inst?]]

   ;; Add new todo entity
   :todo/id :uuid
   :todo [:map {:closed true}
          [:xt/id :todo/id]
          [:todo/title :string]
          [:todo/done boolean?]
          [:todo/created-at inst?]]
   
      :test/id :uuid
     :test [:map {:closed true}
            [:xt/id :test/id]
            [:test/first-name :string]
            [:test/last-name :string]
            [:test/email :string]
            [:test/created-at inst?]]
   })

(def module
  {:schema schema})
