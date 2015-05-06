(defproject clojure-rest-server "0.1.0-SNAPSHOT"
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler clojure-rest-server.core/handler}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [liberator "0.10.0"]
                 [compojure "1.1.3"]
                 [ring/ring-core "1.2.1"]])
