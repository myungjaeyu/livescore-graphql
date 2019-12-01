(ns livescore-graphql.graphql.resolver.core
  (:require [clojure.core.match :refer [match]]
            [livescore-graphql.crawler.core :refer [get-events get-event]]))

(defn resolver-fn [type-name field-name]
  (match [type-name field-name]
    ["QueryRoot" "events"] (fn [context parent args]
                            (get-events (get args "type") (get args "date")))
    ["QueryRoot" "event"] (fn [context parent args]
                           (get-event (get args "id")))
    :else nil))