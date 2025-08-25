# === Stage 1: Build the JAR ===
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml first to download dependencies (caching)
COPY pom.xml .

# Copy the source code
COPY src ./src

# Build the application JAR
RUN mvn clean package -DskipTests

# === Stage 2: Run the JAR ===
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]