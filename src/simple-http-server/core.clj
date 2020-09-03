(ns simple-http-server.core
  (:require [org.httpkit.server :as server]
            [clojure.test :refer :all]))

(defn d [arg]
  (prn arg)
  arg)

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
  (d (case (:uri (d req))
       "/health-check" (health-check req)
       "/docs" (docs req)
       "/enrich" (enrich req))))

(defn main [arg]
  (server/run-server #'routing {:port arg}))

(comment
  (main 8888)

  (main 8887)

  (main 8886)

  (main 8885)

  )
