(ns excelman.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[excelman started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[excelman has shut down successfully]=-"))
   :middleware identity})
