FROM openjdk:11

COPY target/*.jar app.jar
#ADD target/*.jar app.jar

ENTRYPOINT  ["java","-jar","/app.jar"]

EXPOSE 8081
