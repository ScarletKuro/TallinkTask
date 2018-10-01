FROM openjdk:8-jdk-alpine
COPY ./target/conferenceapp-0.0.1-SNAPSHOT.jar /usr/src/hola/
WORKDIR /usr/src/hola
EXPOSE 8081
CMD ["java", "-jar", "conferenceapp-0.0.1-SNAPSHOT.jar"]