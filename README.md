# livescore-graphql

## Usage

```
$ lein run
```

Request URL - `POST` `http://localhost:3000/graphql`

## GraphQL Specification

#### Query events

```graphql
query {
    events (type: "football" date: "2019-11-28" ) {
        id
        sport
        categoryId
        categoryName
        title
        status
        time
        homeName
        homeScore
        awayName
        awayScore
        startDate
    }
}
```

#### Query event

```graphql
query {
    event (id: 8464017) {
        id
        sport
        categoryId
        categoryName
        title
        status
        time
        homeName
        homeScore
        awayName
        awayScore
        startDate
    }
}
```