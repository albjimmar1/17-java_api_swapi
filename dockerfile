FROM openjdk:17
COPY target/swapi-0.0.1-SNAPSHOT.jar starWarsAPI.jar
ENTRYPOINT ["java", "-jar", "starWarsAPI.jar"]