#FROM adoptopenjdk/openjdk11:alpine-jre
FROM bachden/ubuntu-oraclejdk11
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]