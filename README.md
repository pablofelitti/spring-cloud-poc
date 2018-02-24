# Spring Cloud POC

This is a project to test a standard microservice architecture

# How to run

Default ports can be modified in docker-compose.yml file

## Compile everything

```
mvn package
docker-compose build
docker-compose up
```

## Then run all the containers

```
docker-compose up
``` 

# Containers included

## Service registry

This is a Eureka Service Registry server where microservices will register themselves

```
localhost:1111
```

## User microservice

This is a microservice example for User services

```
localhost:8080
```

# TODO: Config server, API Gateway, Histryx...