FROM adoptopenjdk/openjdk11

COPY target/*.jar app.jar

EXPOSE 9966

CMD ["java","-jar","/app.jar"]
