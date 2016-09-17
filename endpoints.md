Endpoints
=========

ExerciseTasks
-------------

`/tasks/ex` - listuje wszystkie zadania

```
[
  {
    "id": 5,
    "description": "desc",
    "exampleCorrectQuery": "select first_name, last_name from actor where first_name like 'B%'",
    "category": "select"
  },
  {
    "id": 11,
    "description": "get all actors",
    "exampleCorrectQuery": "select * from actor;",
    "category": "select"
  }
]
```

`/tasks/ex/add` - dodaje zadanie

```
{
	"description":"get all actors",
	"exampleCorrectQuery": "select * from actor;",
	"category": "select"
}
```

`/tasks/ex/{id}` - zwraca zadanie o danym id

dla /tasks/ex/11
```
{
  "id": 11,
  "description": "get all actors",
  "exampleCorrectQuery": "select * from actor;",
  "category": "select"
}
```

QueryCheck
----------

`/query/check/{id}` - sprawdza czy zapytanie wysłane przez użytkownika zwraca to samo co zadanie o zadanym id,

dla /query/check/11
```
{
	"query":"select * from actor"
}
```

```
{
  "correct": true,
  "results": [
  {
      "ACTOR_ID": "1",
      "LAST_UPDATE": "2013-05-26 14:47:57.62",
      "LAST_NAME": "Guiness",
      "FIRST_NAME": "Penelope"
    },
    {
      "ACTOR_ID": "2",
      "LAST_UPDATE": "2013-05-26 14:47:57.62",
      "LAST_NAME": "Wahlberg",
      "FIRST_NAME": "Nick"
    },
    {
      "ACTOR_ID": "3",
      "LAST_UPDATE": "2013-05-26 14:47:57.62",
      "LAST_NAME": "Chase",
      "FIRST_NAME": "Ed"
    },
    {
      "ACTOR_ID": "4",
      "LAST_UPDATE": "2013-05-26 14:47:57.62",
      "LAST_NAME": "Davis",
      "FIRST_NAME": "Jennifer"
    }
    (...)
    ],
"errorMessage": ""
}
```

correct - czy query jest poprawne
errorMessage - ewentualny zrzut błędu bazy na złe gramatycznie query
jeśli errorMessage nie jest puste to zawsze correct = false


`/query/exec` - wykonuje przesłane zapytanie
przykład jsona wejściowego i wyjściowego taki sam jak przy query/check
correct - zawsze jest na true, jeśli errorMessage == ""
