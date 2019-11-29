(ns livescore-graphql.core
  (:use org.httpkit.server)
  (:require [compojure.handler :refer [api]]
            [ring.middleware.json :refer [wrap-json-params wrap-json-response]]
            [livescore-graphql.routes :refer [routes]])
  (:gen-class))

(def app
  (-> (api routes)
      wrap-json-params
      wrap-json-response))

(defn -main []
  (run-server app {:port 3000})
  (println "livescore-graphql"))