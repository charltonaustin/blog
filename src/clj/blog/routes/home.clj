(ns blog.routes.home
  (:require [blog.layout :as layout]
            [blog.db.core :as db]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [blog.helpers.core :refer [get-published-files 
                                       get-name 
                                       content-for 
                                       parse-year-month
                                       about-page-content]]))


(defn get-archive-links [] 
  (into [] (into (sorted-set) (map #(:archive-date %) (get-published-files)))))

(defn home-page []
  (let [first-three (take 3 (get-published-files))
        with-content (map #(assoc % :content (content-for (:location %))) first-three)]
    (layout/render
     "home.html" 
     {:home-active "active"
      :title-tag "Charlton Austin's Blog Technical Dazed And Confused Home Page"
      :description-tag "The landing page for my blog. It contains the three latest blog posts that I have written."
      :blog-posts-with-content with-content
      :next (:url (nth (get-published-files) 3))
      :previous "/"
      :archive-links (get-archive-links) })))


(defn blog-post [year month day blog-post-name]
  (let [name (get-name blog-post-name)
        filtered (filter #(= (:name %) name) (get-published-files))
        with-content (map #(assoc % :content (content-for (:location %))) filtered)] 
    (layout/render 
     "home.html" 
     {:title-tag (str "Charlton's Blog Post About: " name)
      :blog-posts-with-content with-content
      :description-tag (first (str/split (:content (first with-content)) #"\."))
      :single? "single-"
      :next (get (nth (get-published-files) (+ 1 (:index (first filtered))) {}) :url "/")
      :previous (get (nth (get-published-files) (- (:index (first filtered)) 1) {}) :url "/")
      :archive-links (get-archive-links) })))

(defn format-date [date]
  (if (= (type date) java.util.Date)
    (.format (java.text.SimpleDateFormat. "/yyyy/M") date)
    date))

(defn archive-posts [year month]
  (let [url (str "/" year "/" month)
        filtered 
        (filter 
         #(= (format-date (:archive-date %)) url) 
         (get-published-files))
        url-index (.indexOf (map #(format-date %) (get-archive-links)) url)
        with-content (map #(assoc % :content (content-for (:location %))) filtered)]
    (layout/render 
     "home.html"
     {:title-tag (str "Charlton's Archive of Blog Posts from: " year "/" month)
      :blog-posts-with-content with-content
      :next (format-date (nth (get-archive-links) (+ 1 url-index) "/")) 
      :previous (format-date (nth (get-archive-links) (- url-index 1) "/"))
      :archive-links (get-archive-links)})))

(defn about-page []
  (layout/render 
   "about.html" 
   {:about-active "active"
    :description-tag "A page describin who I am and what I'm doing with this blog."
    :title-tag (:title "Charlton Austin's Blog Technical Dazed And Confused About Page")
    :content (about-page-content)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/:year/:month"
       [year month]
       (archive-posts year month))
  (GET "/:year/:month/:day/:blog-post-name" 
       [year month day blog-post-name] 
       (blog-post year month day blog-post-name)))

