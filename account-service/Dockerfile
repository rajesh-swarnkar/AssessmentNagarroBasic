# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine
# Copy the JAR file to the container
ADD target/account-service-0.0.1-SNAPSHOT.jar account-service-0.0.1-SNAPSHOT.jar
# Run the application
ENTRYPOINT ["java","-jar","/account-service-0.0.1-SNAPSHOT.jar"]