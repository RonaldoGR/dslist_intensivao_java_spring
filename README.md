#  DSList Intensivão Java Spring

![Java](https://img.shields.io/badge/Java-21-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen?logo=springboot)
![License](https://img.shields.io/badge/license-MIT-lightgrey)
![Docker](https://img.shields.io/badge/containerized-Docker-blue?logo=docker)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

This is a REST API for collection games built with Spring Boot was taught in Intensivao Java Spring by professor Nelio from DevSuperior plataform.

Technologies used

- Java 21
- Spring Boot 3.5.3
- JPA
- H2
- PostgreSQL
- Lombok
- Mockito
- JUnit 5
- Maven
- Docker

---

## Running with Docker

###  Requirements

- Docker installed and running (e.g., Docker Desktop)

### Steps

1. **Clone the repository:**
```
git clone https://github.com/RonaldoGR/dslist_intensivao_java_spring.git
cd dslist_intensivao_java_spring
```


2. **Build the Docker image:**
```
docker build -t dslist .
```

4. **Run the container:**
```
docker run -p 8080:8080 dslist
```

5. **Call the API endpoint:**

Open in your browser for GET methods or Postman(or another app) for POST methods also:
```
GET http://localhost:8080/games -> return all games
GET http://localhost:8080/games/1 -> return game by ID
GET http://localhost:8080/lists -> return the lists of games
GET http://localhost:8080/lists/1/games -> return the games of lists by ID
```
```
POST http://localhost:8080/lists/2/replacement -> replace games on list by request body
```
**Example request body:**
```json
{
  "sourceIndex": 3,
  "destinationIndex": 1
}
```

For more details open the DSList.postman_collection.json.

##  Running tests
**Running tests inside Docker**

Assuming the Docker image is already built, run the tests with:
```
docker run --rm dslist mvn test
```

**To run unit tests outside Docker, make sure you have the following installed locally:**

###  Requirements

- Java 21 (same as the project)
- Internet access (to download dependencies the first time)
- One of the following:
    - Maven installed globally
    - Or use the included Maven Wrapper (./mvnw)

###  How to run

If you have Maven installed:
```
mvn test
```
Or, using the Maven Wrapper:
```
./mvnw test
```

The test suite uses JUnit 5 and Mockito and is located in:
```
src/test/java/br/com/devsuperior/dslist/services/GameListServiceTest.java
src/test/java/br/com/devsuperior/dslist/services/GameServiceTest.java
```

✅ The tests validate the logic of methods from services.

## Project structure
-	Dockerfile: containerization configuration
### main
- controllers: exposes the endpoints of application
-	services: handles the research of games, lists and replacement games method
-	entites: defines the entities on database
-	dto: return DTOs based on entities
-	repository: connect database on application
-	projections: handles the return value from JPA method
-	exceptions: handles treatment exceptions
### test
- dto: fake dto to handle mock objects
- services: handle service methods

## Special thanks
Professor Nelio Alves.
Follow the links
- https://www.youtube.com/@DevSuperior
- https://www.linkedin.com/in/nelio-alves/
## Autor
Ronaldo Gandra Rocha - Academic at IFSUL (Federal Institute of Education, Science and Technology) - undergraduate in Internet Systems Technology