# BFH Webhook Solver

Spring Boot automation application that dynamically fetches a SQL problem, solves it, and submits the solution using JWT authentication.

## Features
- Auto executes on application startup
- Calls generateWebhook API
- Determines assigned question using RegNo parity
- Generates SQL solution
- Submits solution to webhook using JWT
- No controller endpoints (background worker)

## Tech Stack
Java 17+
Spring Boot 3
RestTemplate
Maven

## Run Instructions

### Using JAR
java -jar webhooksolver-0.0.1-SNAPSHOT.jar

### Build from source
mvn clean package
java -jar target/webhooksolver-0.0.1-SNAPSHOT.jar
