(ns livescore-graphql.routes
  (:require [compojure.core :refer [defroutes GET]]
            [ring.util.response :refer [response]]))

(defroutes routes
  (GET "/" []
    (response {:message "index"})))