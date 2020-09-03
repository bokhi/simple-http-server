(ns simple-http-server.core
  (:require ;; [org.httpkit.sni-client :as sni-client]
   [org.httpkit.server :as server]))

(defn d [arg]
  (println arg)
  arg)

(defn health-check [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    ""})

(defn docs [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (slurp "/path/index.html")}
  )

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

  (main 8887))
