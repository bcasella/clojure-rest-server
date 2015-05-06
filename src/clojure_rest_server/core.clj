(ns clojure-rest-server.core
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY]]))


(defroutes app
  (ANY "/" [] (resource :available-media-types ["text/html"]
                           :handle-ok "<html>Hello, Internet.</html>")))


(defroutes app
  (ANY "/foo" [] (resource :available-media-types ["text/html"]
                           :handle-ok (fn [ctx]
                                        (format "<html>It's %d milliseconds since the beginning of the epoch."
                                                (System/currentTimeMillis))))))
(def handler
  (-> app
      wrap-params))

(def counter (ref 0))
;;...
(resource :handle-ok (format "The counter is %d" @counter))
;;...

