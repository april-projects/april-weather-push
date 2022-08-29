# syntax=docker/dockerfile:1
# https://docs.docker.com/language/java/build-images/
FROM eclipse-temurin:11-jdk-jammy

VOLUME /tmp

ADD april-weather-push-1.0.0.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
