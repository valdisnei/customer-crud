FROM openjdk:11-jre-slim

LABEL maintainer="valdisnei.fajardo@gmail.com"

VOLUME /target
ADD target/customer-crud-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT exec java -jar -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}  -Duser.timezone=America/Sao_Paulo /app.jar
