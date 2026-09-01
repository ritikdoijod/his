# =========================
# Builder
# =========================

FROM maven:3.9.16-eclipse-temurin-25 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

RUN cp target/*.jar target/app.jar


# =========================
# Runtime
# =========================

FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=builder /app/target/app.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]