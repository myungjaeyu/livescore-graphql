(defproject livescore-graphql "0.1.0-SNAPSHOT"
  :main livescore-graphql.core
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.json "0.2.6"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]
                 [ring "1.7.1"]
                 [ring/ring-json "0.5.0"]
                 [org.clojure/data.json "0.2.7"]
                 [graphql-clj "0.2.6"]]
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}})