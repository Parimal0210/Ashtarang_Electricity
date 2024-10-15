FROM eclipse-temurin:21-jdk-alpine

ADD Ashtarang_Electricity_Invoice-0.0.1.jar Ashtarang_Electricity_Invoice-0.0.1.jar

ENTRYPOINT ["java","-jar","Ashtarang_Electricity_Invoice-0.0.1.jar"]