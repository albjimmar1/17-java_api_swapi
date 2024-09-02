# API functionality

API for querying Star Wars character and planet data.<br>

# Technologies

Java 17<br>
Spring<br>
JUnit<br>
Mockito<br>
JaCoCo<br>
Maven<br>
Docker<br>

# Installation

```sh
git clone https://github.com/albjimmar1/17-java_api_swapi.git
```
```sh
cd 17-java_api_swapi
```
```sh
mvn clean install
```

# Application execution
$PATH = localhost:8080
```sh
mvnw spring-boot:run
```

# Test execution

```sh
mvn test
```

# JaCoCo coverage report

```sh
target/site/jacoco/index.html
```

# Collection of test request

```sh
cd collections
```

# Docker: port 6969

Building an Image
```sh
docker-compose build swapi_app
```
Deploying a Container: $PATH = localhost:6969
```sh
docker-compose up
```

Stop a Container
```sh
docker-compose down
```

# Documentation

Get all characters or planets<br>
```sh
http GET http://{$PATH}/swapi/v1/people/
http GET http://{$PATH}/swapi/v1/planets/
```
Filter by name<br>
```sh
http GET http://{$PATH}/swapi/v1/people/?byName=sky
http GET http://{$PATH}/swapi/v1/planets/?byName=too
```
Pagination<br>
```sh
http GET http://{$PATH}/swapi/v1/people/?limit=15&offset=0
http GET http://{$PATH}/swapi/v1/planets/?limit=15&offset=0
```
Sort ascending and descending by name<br>
```sh
http GET http://{$PATH}/swapi/v1/people/?sortByName=ASC
http GET http://{$PATH}/swapi/v1/people/?sortByName=DESC
http GET http://{$PATH}/swapi/v1/planets/?sortByName=ASC
http GET http://{$PATH}/swapi/v1/planets/?sortByName=DESC
```
Sort ascending and descending by creation date<br>
```sh
http GET http://{$PATH}/swapi/v1/people/?sortByCreated=ASC
http GET http://{$PATH}/swapi/v1/people/?sortByCreated=DESC
http GET http://{$PATH}/swapi/v1/planets/?sortByCreated=ASC
http GET http://{$PATH}/swapi/v1/planets/?sortByCreated=DESC
```