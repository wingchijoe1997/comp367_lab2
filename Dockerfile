FROM openjdk:17
ADD target/lab3.jar lab3.jar
ENTRYPOINT ["java", "-jar", "lab3.jar"]
