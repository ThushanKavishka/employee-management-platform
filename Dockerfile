# define base docker image
FROM openjdk:8-jdk-alpine
LABEL maintainer="expoundlabs.com"
ADD target/employee-management-platform-0.0.1-SNAPSHOT.jar springboot-docker-employee-management.jar
ENTRYPOINT ["java","-jar","springboot-docker-employee-management.jar"]