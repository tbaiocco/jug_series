# NSC JUG
### Spring boot Series - Session 1

This is the result project for the session 1, where you can find the following:

- Spring Boot - initializr project
- Start coding App - configs and needed classes
- Using Maven
- Set H2DB
- Spring Profiles
- TDD - Test first
- CRUD - full entity in DB
- Testing in Postman
- Testing - Embedding Swagger

### How-to

  - MacOS / Linux

```sh
$ ./mvnw spring-boot:run
```
  - Windows
```sh
$ mvnw spring-boot:run
```

##### You can also use profiling:

```sh
$ ./mvnw spring-boot:run -Dspring.profiles.active=prod
```

#### Endpoints:
- HTTP.GET
```sh
http://localhost:8000/
http://localhost:8000/hi?name=Johnny
http://localhost:8000/musicians
http://localhost:8000/musicians/2
```
- HTTP.POST
```sh
http://localhost:8000/musicians
http://localhost:8000/musicians/2
```
- HTTP.PATCH
```sh
http://localhost:8000/musicians/2
```
- HTTP.DELETE
```sh
http://localhost:8000/musicians/2
```
- Console H2
```sh
http://localhost:8000/h2
```