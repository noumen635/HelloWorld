FROM openjdk:11-jre-slim

COPY target/*.jar helloworld.jar

ENTRYPOINT [ "java", "-jar", "/helloworld.jar" ]