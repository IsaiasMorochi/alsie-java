FROM adoptopenjdk/openjdk11:jdk-11.0.15_10_alpine-slim

COPY target/*.jar app.jar

EXPOSE 9966

CMD ["java","-jar","/app.jar"]
