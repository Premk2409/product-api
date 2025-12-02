FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/ecom-proj-0.0.1-SNAPSHOT.jar product-api.jar
ENTRYPOINT ["java", "-jar", "product-api.jar"]
