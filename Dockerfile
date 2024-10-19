FROM eclipse-temurin:21-jdk-alpine AS build
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/Ashtarang_Electricity_Invoice-0.0.1.jar"]