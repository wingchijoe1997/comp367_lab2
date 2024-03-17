# Use an OpenJDK runtime as the base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/Lab3-1.0-SNAPSHOT.jar Lab3.jar

# Run the web application on container startup
CMD ["java", "-jar", "Lab3.jar"]
