FROM adoptopenjdk/openjdk11 as build

COPY target/alsie-java-0.0.1.jar app.jar

EXPOSE 8080

ENTRYPOINT  ["java","-jar","/app.jar"]
