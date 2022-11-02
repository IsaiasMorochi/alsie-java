FROM adoptopenjdk/openjdk11:jdk-11.0.15_alpine-slim

WORKDIR /workspace

COPY target/*.jar app.jar

EXPOSE 9966

CMD ["java","-jar","workspace/app.jar"]