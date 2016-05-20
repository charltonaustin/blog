(ns blog.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [blog.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[blog started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[blog has shutdown successfully]=-"))
   :middleware wrap-dev})
