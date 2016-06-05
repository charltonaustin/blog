(ns blog.routes.home
  (:require [blog.layout :as layout]
            [blog.db.core :as db]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [blog.helpers.core :refer [get-published-files 
                                       get-name 
                                       content-for 
                                       parse-year-month]]))

(def blog-posts (get-published-files))
(def archive-links  
  (into [] (into (sorted-set) (map #(:archive-date %) blog-posts))))

(defn home-page []
  (let [first-three (take 3 blog-posts)
        with-content (map #(assoc % :content (content-for (:location %))) first-three)]
    (layout/render
     "home.html" 
     {:home-active "active"
      :title-tag "Charlton Austin's Blog Technical Dazed And Confused Home Page"
      :blog-posts-with-content with-content
      :next (:url (nth blog-posts 4))
      :previous "/"
      :archive-links archive-links })))


(defn blog-post [year month day blog-post-name]
  (let [name (get-name blog-post-name)
        filtered (filter #(= (:name %) name) blog-posts)
        with-content (map #(assoc % :content (content-for (:location %))) filtered)] 
    (layout/render 
     "home.html" 
     {:title-tag (str "Charlton's Blog Post About: " name)
      :blog-posts-with-content with-content
      :single? "single-"
      :next (get (nth blog-posts (+ 1 (:index (first filtered))) {}) :url "/")
      :previous (get (nth blog-posts (- (:index (first filtered)) 1) {}) :url "/")
      :archive-links archive-links })))

(defn archive-posts [year month]
  (let [url (str "/" year "/" month)
        filtered 
        (filter 
         #(= (.format (java.text.SimpleDateFormat. "/yyyy/M") (:archive-date %)) url) 
         blog-posts)
        url-index (.indexOf (map #(:url %) archive-links) url)
        with-content (map #(assoc % :content (content-for (:location %))) filtered)]
    (layout/render 
     "home.html"
     {:title-tag (str "Charlton's Archive of Blog Posts from: " year "/" month)
      :blog-posts-with-content with-content
      :next (:url (nth archive-links (+ 1 url-index) "/"))
      :previous (:url (nth archive-links (- url-index 1) "/"))
      :archive-links archive-links})))

(defn about-page []
  (layout/render 
   "about.html" 
   {:about-active "active"
    :title-tag (:title "Charlton Austin's Blog Technical Dazed And Confused About Page")}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/:year/:month"
       [year month]
       (archive-posts year month))
  (GET "/:year/:month/:day/:blog-post-name" 
       [year month day blog-post-name] 
       (blog-post year month day blog-post-name)))

