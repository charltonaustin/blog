(ns blog.helpers.test.core
  (:require [clojure.test :refer :all]
            [blog.helpers.core :refer :all]))
(defn get-list-of-file-names []
  '("/home/charlie/dev/clojure/blog-entries/published" "/home/charlie/dev/clojure/blog-entries/published/2015" "/home/charlie/dev/clojure/blog-entries/published/2015/1" "/home/charlie/dev/clojure/blog-entries/published/2015/1/28" "/home/charlie/dev/clojure/blog-entries/published/2015/1/28/refactoring-tests-for-maintainability.md" "/home/charlie/dev/clojure/blog-entries/published/2015/10" "/home/charlie/dev/clojure/blog-entries/published/2015/10/24" "/home/charlie/dev/clojure/blog-entries/published/2015/10/24/debugging-multi--threaded-applications.md" "/home/charlie/dev/clojure/blog-entries/published/2015/10/10" "/home/charlie/dev/clojure/blog-entries/published/2015/10/10/feature-branches-to-mainline.md" "/home/charlie/dev/clojure/blog-entries/published/2015/11" "/home/charlie/dev/clojure/blog-entries/published/2015/11/7" "/home/charlie/dev/clojure/blog-entries/published/2015/11/7/structual-type-systems.md" "/home/charlie/dev/clojure/blog-entries/published/2015/11/11" "/home/charlie/dev/clojure/blog-entries/published/2015/11/11/protonMail-or-why-security-matters.md" "/home/charlie/dev/clojure/blog-entries/published/2015/9" "/home/charlie/dev/clojure/blog-entries/published/2015/9/26" "/home/charlie/dev/clojure/blog-entries/published/2015/9/26/making-pairing-comfortable.md" "/home/charlie/dev/clojure/blog-entries/published/2015/9/19" "/home/charlie/dev/clojure/blog-entries/published/2015/9/19/configurator-boxen-or-things-to-wrangle-your-environment.md" "/home/charlie/dev/clojure/blog-entries/published/2016" "/home/charlie/dev/clojure/blog-entries/published/2016/3" "/home/charlie/dev/clojure/blog-entries/published/2016/3/3" "/home/charlie/dev/clojure/blog-entries/published/2016/3/3/the-expression-problem.md" "/home/charlie/dev/clojure/blog-entries/published/2016/5" "/home/charlie/dev/clojure/blog-entries/published/2016/5/10" "/home/charlie/dev/clojure/blog-entries/published/2016/5/10/quitting-finance-and-trying-to-give-back.md" "/home/charlie/dev/clojure/blog-entries/published/2016/4" "/home/charlie/dev/clojure/blog-entries/published/2016/4/24" "/home/charlie/dev/clojure/blog-entries/published/2016/4/24/clojure-sieve-of-eratosthenes.md" "/home/charlie/dev/clojure/blog-entries/published/2016/4/26" "/home/charlie/dev/clojure/blog-entries/published/2016/4/26/top-down-vs-bottom-up-API-design-in-clojure-part-one.md" "/home/charlie/dev/clojure/blog-entries/published/2016/4/12" "/home/charlie/dev/clojure/blog-entries/published/2016/4/12/does-unit-testing-make-me-slower.md" "/home/charlie/dev/clojure/blog-entries/published/2016/4/20" "/home/charlie/dev/clojure/blog-entries/published/2016/4/20/the-count-down-problem.md" "/home/charlie/dev/clojure/blog-entries/published/2016/4/20/top-down-vs-bottom-up-api-design-in-clojure-part-zero.md" "/home/charlie/dev/clojure/blog-entries/published/2016/4/7" "/home/charlie/dev/clojure/blog-entries/published/2016/4/7/writing-distributed-test-reduction.md" "/home/charlie/dev/clojure/blog-entries/published/2016/4/13" "/home/charlie/dev/clojure/blog-entries/published/2016/4/13/unit-testing-with-higher-order-functions.md" "/home/charlie/dev/clojure/blog-entries/published/2016/4/4" "/home/charlie/dev/clojure/blog-entries/published/2016/4/4/python-source-code-gems.md" "/home/charlie/dev/clojure/blog-entries/published/2013" "/home/charlie/dev/clojure/blog-entries/published/2013/3" "/home/charlie/dev/clojure/blog-entries/published/2013/3/6" "/home/charlie/dev/clojure/blog-entries/published/2013/3/6/problems-with-cucumber-and-chef.md" "/home/charlie/dev/clojure/blog-entries/published/2013/3/1" "/home/charlie/dev/clojure/blog-entries/published/2013/3/1/clojure-web-scraper.md" "/home/charlie/dev/clojure/blog-entries/published/2013/2" "/home/charlie/dev/clojure/blog-entries/published/2013/2/17" "/home/charlie/dev/clojure/blog-entries/published/2013/2/17/frank-cucumber.md" "/home/charlie/dev/clojure/blog-entries/published/2013/2/27" "/home/charlie/dev/clojure/blog-entries/published/2013/2/27/vagrant-chef-fun.md"))

(def just-file-locations '("/home/charlie/dev/clojure/blog-entries/published/2016/5/10/quitting-finance-and-trying-to-give-back.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/4/7/writing-distributed-test-reduction.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/4/4/python-source-code-gems.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/4/26/top-down-vs-bottom-up-API-design-in-clojure-part-one.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/4/24/clojure-sieve-of-eratosthenes.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/4/20/top-down-vs-bottom-up-api-design-in-clojure-part-zero.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/4/20/the-count-down-problem.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/4/13/unit-testing-with-higher-order-functions.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/4/12/does-unit-testing-make-me-slower.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/3/3/the-expression-problem.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/9/26/making-pairing-comfortable.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/9/19/configurator-boxen-or-things-to-wrangle-your-environment.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/11/7/structual-type-systems.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/11/11/protonMail-or-why-security-matters.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/10/24/debugging-multi--threaded-applications.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/10/10/feature-branches-to-mainline.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/1/28/refactoring-tests-for-maintainability.md"
           "/home/charlie/dev/clojure/blog-entries/published/2013/3/6/problems-with-cucumber-and-chef.md"
           "/home/charlie/dev/clojure/blog-entries/published/2013/3/1/clojure-web-scraper.md"
           "/home/charlie/dev/clojure/blog-entries/published/2013/2/27/vagrant-chef-fun.md"
           "/home/charlie/dev/clojure/blog-entries/published/2013/2/17/frank-cucumber.md"))

(deftest test-app
  (testing "capitalize-first-word"
    (let [actual (capitalize-first-word "i am a blog post", #" ")]
      (is (= actual "I Am A Blog Post"))))

  (testing "get-file-locations"
    (let [actual (get-file-locations (get-list-of-file-names))]
      (is (= actual just-file-locations))))

  (testing "get-name"
    (let [actual (get-name (first just-file-locations))]
      (is (= actual "Quitting Finance And Trying To Give Back"))))
  
  (testing "get-date"
    (let [actual (.format 
                  (java.text.SimpleDateFormat. "dd.MM.yyyy") 
                  (get-date (first just-file-locations)))]
      (is (= actual "10.05.2016"))))

  (testing "get-archive-date"
    (let [actual (.format
                  (java.text.SimpleDateFormat. "dd.MM.yyyy")
                  (get-archive-date (first just-file-locations)))]
      (is (= actual "01.05.2016"))))

  (testing "get-url"
    (with-redefs [blog.helpers.core/read-paths-from-drive get-list-of-file-names]
      (let [actual (first (get-published-files))]
        (is (= (:location actual) "/home/charlie/dev/clojure/blog-entries/published/2016/5/10/quitting-finance-and-trying-to-give-back.md"))
        (is (= (:index actual) 0))
        (is (contains? actual :archive-date))
        (is (contains? actual :url))
        (is (contains? actual :publish-date))
        (is (contains? actual :name)))))
)
