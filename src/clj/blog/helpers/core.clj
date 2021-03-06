(ns blog.helpers.core
  (:require [clojure.java.io :as io]
	    [blog.config :refer [env]]
            [clojure.string :as str]
            [mount.core :as mount]
))

(mount/start #'blog.config/env) 

(defn read-paths-from-drive []
  (->> (io/file (env :blog-posts))
       (file-seq)
       (map #(.getPath %))))

(defn get-file-locations [paths]
  (->> paths
       (filter #(re-find #"\.md" %))
       (map #(str/replace-first % "" ""))
       (sort)
       (reverse)
       ))

(defn capitalize-first-word [word regex]
  (->> (str/split word regex)
       (map str/capitalize)
       (str/join " ")))

(defn get-name [file-location] 
  (-> file-location
       (str/replace-first (env :blog-posts) "")
       (str/replace-first #".md" "")
       (str/replace  #"-" " ")
       (str/replace #"\d+/\d+/\d+/" "")
       (capitalize-first-word #" ")))

(defn parse-date [date-string]
   (.parse
      (java.text.SimpleDateFormat. "yyyy/MM/dd")
      date-string))

(defn find-date [str]
  (re-find #"\d+/\d+/\d+" str))

(defn get-date [file-location]
  (-> file-location
      find-date
      parse-date))

(defn find-year-month [str]
  (re-find #"/\d+/\d+" str))

(defn parse-year-month [date-string]
 (.parse
      (java.text.SimpleDateFormat. "/yyyy/MM")
      date-string))

(defn get-archive-date [file-location]
  (-> file-location
      find-year-month
      parse-year-month))

(defn get-url [file-location]
  (-> file-location
      (str/replace-first (env :blog-posts) "/")
      (str/replace-first #".md" "")))

(defn content-for [name]
  (-> name slurp))

(defn about-page-content []
  (slurp (str (env :blog-posts) "../about.md")))

(defn get-published-files []
  (let [file-locations (get-file-locations (read-paths-from-drive))]
    (->> file-locations
         (map #(assoc {} :location %))
         (map #(assoc % :name (get-name (:location %))))
         (map #(assoc % :publish-date (get-date (:location %))))
         (map #(assoc % :url (get-url (:location %))))
         (map #(assoc % :archive-date (get-archive-date (:location %))))
         (map-indexed (fn [index item] (assoc item :index index))))))

