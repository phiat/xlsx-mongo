(ns excelman.db.core
    (:require
     [monger.core :as mg]
     [monger.collection :as mc]
     [monger.operators :refer :all]
     [mount.core :refer [defstate]]
     [excelman.config :refer [env]]
     [clojure.data.json :as json]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

(defn create-item [item]
  (mc/insert db "items" item))

; (defn update-user [id first-name last-name email]
;   (mc/update db "users" {:_id id}
;              {$set {:first_name first-name
;                     :last_name last-name
;                     :email email}}))

; (defn get-user [id]
;   (mc/find-one-as-map db "users" {:_id id}))
