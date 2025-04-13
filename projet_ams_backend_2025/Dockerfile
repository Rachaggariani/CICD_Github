# Use official Maven image as build stage
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests

# Use official OpenJDK image as runtime stage
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/ams.jar .

EXPOSE 8085

CMD ["java", "-jar", "ams.jar"]