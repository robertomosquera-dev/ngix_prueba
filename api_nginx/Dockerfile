FROM amazoncorretto:21-alpine

WORKDIR /app

COPY pom.xml .
COPY .mvn ./.mvn
COPY mvnw .

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

LABEL authors="rob"

ENTRYPOINT ["java", "-jar", "/app/target/nginx-lab-0.0.1-SNAPSHOT.jar"]