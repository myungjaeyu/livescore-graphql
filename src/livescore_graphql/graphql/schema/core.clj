(ns livescore-graphql.graphql.schema.core)

(def schema-str "
  type Event {
    id: Int
    sport: String
    categoryId: String
    categoryName: String
    title: String
    status: String
    time: String
    homeName: String
    homeScore: Int
    awayName: String
    awayScore: Int
    startDate: Int
  }

  type QueryRoot {
    events(type: String date: String): [Event]
    event(id: Int): Event
  }

  schema {
    query: QueryRoot
  }")