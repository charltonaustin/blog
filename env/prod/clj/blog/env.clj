(ns blog.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[blog started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[blog has shutdown successfully]=-"))
   :middleware identity})
