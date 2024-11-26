# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

FROM maven:3.8-jdk-11-slim

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:resolve

COPY src ./src

RUN mvn clean install

# Copy the JAR file to the container
ADD target/account-service-0.0.1-SNAPSHOT.jar account-service-0.0.1-SNAPSHOT.jar
# Run the application
ENTRYPOINT ["java","-jar","/account-service-0.0.1-SNAPSHOT.jar"]