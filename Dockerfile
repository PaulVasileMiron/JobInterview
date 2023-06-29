FROM eclipse-temurin:11
ARG JAR_FILE=target/*.jar
COPY ./target/interview_challenfe-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]