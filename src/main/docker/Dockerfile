# syntax=docker/dockerfile:1
# https://docs.docker.com/language/java/build-images/
FROM eclipse-temurin:11-jdk-jammy

VOLUME /usr/local/april-weather-push

ADD april-weather-push-1.0.0.jar april-weather-push-1.0.0.jar

ENTRYPOINT ["java","-jar","/april-weather-push-1.0.0.jar"]
