FROM openjdk-11-alpine

COPY target/*.jar alsie-java.jar

ENTRYPOINT ["java","-jar","/alsie-java.jar"]