(ns excelman.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [excelman.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[excelman started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[excelman has shut down successfully]=-"))
   :middleware wrap-dev})
