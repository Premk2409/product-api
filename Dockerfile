FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/product-api.jar product-api.jar
ENTRYPOINT ["java", "-jar", "product-api.jar"]
