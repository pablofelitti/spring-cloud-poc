FROM openjdk:8
WORKDIR /
RUN mkdir service-registry
WORKDIR service-registry
COPY target/service-registry-1.0-SNAPSHOT.jar .
CMD ["java", "-jar", "service-registry-1.0-SNAPSHOT.jar"]