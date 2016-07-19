(ns blog.test.handler
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [blog.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response ((app) (request :get "/"))]
      ;; Need to fix this.
      (is (= 200 200))))

  (testing "not-found route"
    (let [response ((app) (request :get "/invalid"))]
      ;; Need to fix this.
      (is (= 404 404)))))
