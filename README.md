# Person Management REST API

This is a Spring Boot REST API that manages a list of persons, allowing basic CRD (Create, Read, Delete) operations based on a person's birth number.
Update is not possible, since it was not required.

## Project Overview

This API allows users to:
- Retrieve a list of all persons
- Add a new person
- Find a person by their birth number
- Remove a person by their birth number

The API stores data in an in-memory database for simplicity.

## Example Requests

### List all persons (including 1000 mock persons)
```
curl -X GET http://localhost:8080/api/person -H "Content-Type: application/json"
```

### Add a new person
```
curl -X POST http://localhost:8080/api/person \
-H "Content-Type: application/json" \
-d '{"firstName": "John", "lastName": "Doe", "birthNumber": "9001011234"}'
```

### Retrieve a person
```
curl -X GET http://localhost:8080/api/person/9001011234 -H "Content-Type: application/json"
```

### Delete a person 
```
curl -X DELETE http://localhost:8080/api/person/9001011234 -H "Content-Type: application/json"
```