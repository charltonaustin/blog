(ns blog.routes.home
  (:require [blog.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
   "home.html" {:home-active "active"
                :title-tag "Charlton Austin's Blog Technical Dazed And Confused Home Page"}))

(defn about-page []
  (layout/render "about.html" {:about-active "active"
                               :title-tag "Charlton Austin's Blog Technical Dazed And Confused About Page"}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))

