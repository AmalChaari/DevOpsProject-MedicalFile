FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} medical-file-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/medical-file-0.0.1-SNAPSHOT.jar"]