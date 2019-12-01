(ns livescore-graphql.routes
  (:require [compojure.core :refer [defroutes POST]]
            [livescore-graphql.graphql.core :refer [execute]]
            [ring.util.response :refer [response]]))

(defroutes routes
  (POST "/graphql" [query]
    (response (execute query))))