(ns blog.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [blog.handler :refer :all]))

(defn content-for-stub []
  "some great content")

(defn get-published-files-stub []
  '({:location "/some/location/file.md" 
     :name "File" 
     :publish-date (new java.util.Date) 
     :url "/some/location/file"
     :archive-date (new java.util.Date)
     :index 3}))

(deftest test-app
  (testing "main route"
    (with-redefs [blog.helpers.core/content-for content-for-stub 
                  blog.helpers.core/get-published-files get-published-files-stub
                  blog.db.core/create-visit! (fn [& more] )]
      (let [response ((app) (request :get "/"))]
        #(is (= 200  (:status response)))
        #(is (= (:body response) "some great content")))))

  (testing "not-found route"
    (with-redefs [blog.db.core/create-visit! (fn [& more])]
      (let [response ((app) (request :get "/invalid"))]
        (is (= 404 (:status response)))))))
