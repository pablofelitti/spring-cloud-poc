FROM openjdk:8
WORKDIR /
RUN mkdir user-microservice
WORKDIR user-microservice
COPY target/user-microservice-1.0-SNAPSHOT.jar .
CMD ["java", "-jar", "user-microservice-1.0-SNAPSHOT.jar"]