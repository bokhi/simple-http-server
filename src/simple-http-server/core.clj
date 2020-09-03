(ns simple-http-server.core
  (:require [org.httpkit.server :as server]
            [clojure.test :refer :all]
            [clojure.tools.logging :as log]))

(defn health-check [req]
  {:status  200
   :headers {"Content-Type" "texhtml"}
   :body    ""})

(defn docs [req]
  {:status  200
   :headers {"Content-Type" "texhtml"}
   :body (slurp "/home/boki/clojure/kaka/assets/index.html")
   ;; (slurp "http://clojuredocs.org")
   })

(defn enrich [req])

(defn routing [req]
  (log/info "incoming request " req)
  (let [response (case (:uri req)
                   "/health-check" (health-check req)
                   "/docs" (docs req)
                   "/enrich" (enrich req))]
    (log/info "response " response)
    response))

(defn main [arg]
  (server/run-server #'routing {:port arg}))

(comment
  (main 8888)

  (main 8887)

  (main 8886)

  (main 8885)

  )
