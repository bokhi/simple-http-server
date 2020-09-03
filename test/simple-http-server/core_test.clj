(ns simple-http-server.core-test
  (:require [simple-http-server.core :as sut]
            [clojure.test :as t]))

(t/deftest simple-test
  (t/is (= (:status (sut/health-check {})) 200)))
