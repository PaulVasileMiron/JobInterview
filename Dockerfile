FROM eclipse-temurin:11
ARG JAR_FILE=target/*.jar
COPY ./target/SimilarProducts-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]