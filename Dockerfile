#
# Build stage
#
FROM maven:3.8-openjdk-11 AS build
COPY src src
COPY pom.xml pom.xml
RUN mvn -f pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jdk
COPY --from=build target/GardenApp-0.0.1-SNAPSHOT.jar GardenApp-0.0.1-SNAPSHOT.jar
EXPOSE 8080


