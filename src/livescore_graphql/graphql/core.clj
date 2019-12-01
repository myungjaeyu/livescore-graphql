(ns livescore-graphql.graphql.core
  (:require [graphql-clj.executor :as executor]
            [livescore-graphql.graphql.schema.core :refer [schema-str]]
            [livescore-graphql.graphql.resolver.core :refer [resolver-fn]]))

(defn execute [query]
  (executor/execute nil schema-str resolver-fn query))