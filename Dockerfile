# -----------------------
# Stage 1 - Build JAR
# -----------------------
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom and source code
COPY pom.xml .
COPY src ./src

# Package the application (skip tests if needed)
RUN mvn clean package -DskipTests

# ----------------------------
# Stage 2 - Run Spring Boot
# ----------------------------
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
