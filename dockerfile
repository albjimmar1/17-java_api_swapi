FROM maven:3.8.4 AS build
COPY src /src
COPY pom.xml /
RUN mvn clean install -DskipTests

FROM openjdk:17
COPY --from=build "/target/swapi-0.0.1-SNAPSHOT.jar" "starWarsAPI.jar"
ENTRYPOINT ["java", "-jar", "starWarsAPI.jar"]