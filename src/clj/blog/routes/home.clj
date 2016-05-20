(ns blog.routes.home
  (:require [blog.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
   "home.html" { :docs (-> "docs/docs.md" io/resource slurp)
                 :home-active "active"}))

(defn about-page []
  (layout/render "about.html" {:about-active "active"}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))

