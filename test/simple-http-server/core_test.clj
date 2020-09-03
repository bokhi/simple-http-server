(ns simple-http-server.core-test
  (:require [clojure.test :refer :all]
            [simple-http-server.core :as sut]))

(deftest simple-test
  (testing "replies"
    (is (= (:status (sut/health-check {})) 200))
    (is (= (sut/enrich {}) nil)))
  (testing "routing"
    (is (= (:body (sut/routing {:uri "/health-check"})) ""))))
