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
FROM openjdk:11-jdk-alpine
COPY --from=build target/GardenApp-0.0.1-SNAPSHOT.jar GardenApp-0.0.1-SNAPSHOT.jar
EXPOSE 8080

#ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
#FROM openjdk:18-jdk-alpine
#MAINTAINER KT
#COPY target/GardenApp-0.0.1-SNAPSHOT.jar GardenApp-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/GardenApp-0.0.1-SNAPSHOT.jar"]
