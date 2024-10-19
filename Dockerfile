FROM eclipse-temurin:21-jdk-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/Ashtarang_Electricity_Invoice-0.0.1.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar"," demo.jar"]