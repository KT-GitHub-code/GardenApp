FROM openjdk:18-jdk-alpine
MAINTAINER KT
COPY target/GardenApp-0.0.1-SNAPSHOT.jar GardenApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/GardenApp-0.0.1-SNAPSHOT.jar"]