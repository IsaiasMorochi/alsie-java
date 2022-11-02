FROM adoptopenjdk/openjdk11 as build

ARG JAR_FILE=target/alsie-java-0.0.1.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT  ["java","-jar","/app.jar"]
