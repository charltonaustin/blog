(ns blog.helpers.core-test
  (:require [clojure.test :refer :all]
            [blog.helpers.core :refer :all]))
(defn get-list-of-file-names []
  '("/home/charlie/dev/clojure/blog-entries/published"
    "/home/charlie/dev/clojure/blog-entries/published/2015"
    "/home/charlie/dev/clojure/blog-entries/published/2015/01"
    "/home/charlie/dev/clojure/blog-entries/published/2015/01/28"
    "/home/charlie/dev/clojure/blog-entries/published/2015/01/28/refactoring-tests-for-maintainability.md"
    "/home/charlie/dev/clojure/blog-entries/published/2015/10"
    "/home/charlie/dev/clojure/blog-entries/published/2015/10/24"
    "/home/charlie/dev/clojure/blog-entries/published/2015/10/24/debugging-multi--threaded-applications.md"
    "/home/charlie/dev/clojure/blog-entries/published/2015/10/10"
    "/home/charlie/dev/clojure/blog-entries/published/2015/10/10/feature-branches-to-mainline.md"
    "/home/charlie/dev/clojure/blog-entries/published/2015/11"
    "/home/charlie/dev/clojure/blog-entries/published/2015/11/7"
    "/home/charlie/dev/clojure/blog-entries/published/2015/11/07/structual-type-systems.md"
    "/home/charlie/dev/clojure/blog-entries/published/2015/11/11"
    "/home/charlie/dev/clojure/blog-entries/published/2015/11/11/protonMail-or-why-security-matters.md"
    "/home/charlie/dev/clojure/blog-entries/published/2015/09"
    "/home/charlie/dev/clojure/blog-entries/published/2015/09/26"
    "/home/charlie/dev/clojure/blog-entries/published/2015/09/26/making-pairing-comfortable.md"
    "/home/charlie/dev/clojure/blog-entries/published/2015/09/19"
    "/home/charlie/dev/clojure/blog-entries/published/2015/09/19/configurator-boxen-or-things-to-wrangle-your-environment.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016"
    "/home/charlie/dev/clojure/blog-entries/published/2016/03"
    "/home/charlie/dev/clojure/blog-entries/published/2016/03/03"
    "/home/charlie/dev/clojure/blog-entries/published/2016/03/03/the-expression-problem.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016/05"
    "/home/charlie/dev/clojure/blog-entries/published/2016/05/10"
    "/home/charlie/dev/clojure/blog-entries/published/2016/05/10/quitting-finance-and-trying-to-give-back.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/24"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/24/clojure-sieve-of-eratosthenes.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/26"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/26/top-down-vs-bottom-up-API-design-in-clojure-part-one.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/12"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/12/does-unit-testing-make-me-slower.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/20"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/20/the-count-down-problem.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/20/top-down-vs-bottom-up-api-design-in-clojure-part-zero.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/07"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/07/writing-distributed-test-reduction.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/13"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/13/unit-testing-with-higher-order-functions.md"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/04"
    "/home/charlie/dev/clojure/blog-entries/published/2016/04/04/python-source-code-gems.md"
    "/home/charlie/dev/clojure/blog-entries/published/2013"
    "/home/charlie/dev/clojure/blog-entries/published/2013/03"
    "/home/charlie/dev/clojure/blog-entries/published/2013/03/06"
    "/home/charlie/dev/clojure/blog-entries/published/2013/03/06/problems-with-cucumber-and-chef.md"
    "/home/charlie/dev/clojure/blog-entries/published/2013/03/01"
    "/home/charlie/dev/clojure/blog-entries/published/2013/03/01/clojure-web-scraper.md"
    "/home/charlie/dev/clojure/blog-entries/published/2013/02"
    "/home/charlie/dev/clojure/blog-entries/published/2013/02/17"
    "/home/charlie/dev/clojure/blog-entries/published/2013/02/17/frank-cucumber.md"
    "/home/charlie/dev/clojure/blog-entries/published/2013/02/27"
    "/home/charlie/dev/clojure/blog-entries/published/2013/02/27/vagrant-chef-fun.md"))

(def just-file-locations '(
           "/home/charlie/dev/clojure/blog-entries/published/2016/05/10/quitting-finance-and-trying-to-give-back.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/04/26/top-down-vs-bottom-up-API-design-in-clojure-part-one.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/04/24/clojure-sieve-of-eratosthenes.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/04/20/top-down-vs-bottom-up-api-design-in-clojure-part-zero.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/04/20/the-count-down-problem.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/04/13/unit-testing-with-higher-order-functions.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/04/12/does-unit-testing-make-me-slower.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/04/07/writing-distributed-test-reduction.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/04/04/python-source-code-gems.md"
           "/home/charlie/dev/clojure/blog-entries/published/2016/03/03/the-expression-problem.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/11/11/protonMail-or-why-security-matters.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/11/07/structual-type-systems.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/10/24/debugging-multi--threaded-applications.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/10/10/feature-branches-to-mainline.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/09/26/making-pairing-comfortable.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/09/19/configurator-boxen-or-things-to-wrangle-your-environment.md"
           "/home/charlie/dev/clojure/blog-entries/published/2015/01/28/refactoring-tests-for-maintainability.md"
           "/home/charlie/dev/clojure/blog-entries/published/2013/03/06/problems-with-cucumber-and-chef.md"
           "/home/charlie/dev/clojure/blog-entries/published/2013/03/01/clojure-web-scraper.md"
           "/home/charlie/dev/clojure/blog-entries/published/2013/02/27/vagrant-chef-fun.md"
           "/home/charlie/dev/clojure/blog-entries/published/2013/02/17/frank-cucumber.md"

           ))

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
        (is (= (:location actual) "/home/charlie/dev/clojure/blog-entries/published/2016/05/10/quitting-finance-and-trying-to-give-back.md"))
        (is (= (:index actual) 0))
        (is (contains? actual :archive-date))
        (is (contains? actual :url))
        (is (contains? actual :publish-date))
        (is (contains? actual :name)))))
)

(test-app)
