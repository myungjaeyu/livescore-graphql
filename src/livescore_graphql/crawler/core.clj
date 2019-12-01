(ns livescore-graphql.crawler.core
  (:require [org.httpkit.client :as http]
            [clojure.data.json :as json]))

(def URL "https://www.sofascore.com")

(defn get-data [{:keys [id 
                        sport
                        category 
                        name status 
                        statusDescription 
                        homeTeam homeScore 
                        awayTeam awayScore
                        startTimestamp]}]
  {:id id
   :sport (:slug sport)
   :categoryId (:slug category)
   :categoryName (:name category)
   :title name
   :status (:type status)
   :time statusDescription
   :homeName (:name homeTeam)
   :homeScore (:display homeScore)
   :awayName (:name awayTeam)
   :awayScore (:display awayScore)
   :startDate startTimestamp})


(defn get-events-apis [type date]
  (let [url (str URL "/" type "//" date)
        head (http/get (str url "/json"))
        tail (http/get (str url "/inverse/json"))
        handle-api (fn [resp] 
                     (let [{:keys [body]} @resp] 
                       (json/read-str body 
                                      :key-fn keyword)))
        get-data (fn [body] 
                   (-> body 
                       :sportItem 
                       :tournaments))]
    (concat (-> (handle-api head) 
                get-data) 
            (-> (handle-api tail) 
                get-data))))


(defn get-events [type date]
  (->> (get-events-apis type date)
       (reduce 
        (fn [acc {events :events
                  category :category}] 
          (->> events
               (reduce 
                (fn [_ event]
                  (conj acc 
                        (-> (assoc event 
                                   :category category)
                            get-data))) []))) [])))


(defn get-event-api [id]
  (let [{:keys [body]} @(http/get (str URL "/event/" id "/json"))]
    (-> (json/read-str body :key-fn keyword)
        :event)))


(defn get-event [id]
  (->> (get-event-api id)
       get-data))