# =========================
# Runtime
# =========================

FROM eclipse-temurin:25-jre

WORKDIR /app

COPY target/*.jar ./app.jar

EXPOSE 4001

ENTRYPOINT ["java", "-jar", "app.jar"]
