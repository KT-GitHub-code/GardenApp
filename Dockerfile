#
# Build stage
#
FROM maven:3.8-openjdk-17 AS build
COPY src src
COPY pom.xml pom.xml
RUN mvn -f pom.xml clean package -DskipTests=true

#
# Package stage
#
FROM openjdk:17
COPY --from=build target/GardenApp-0.0.1-SNAPSHOT.jar GardenApp-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/GardenApp-0.0.1-SNAPSHOT.jar"]


