FROM openjdk:17
WORKDIR /app
COPY target/product-api.jar product-api.jar
ENTRYPOINT ["java", "-jar", "product-api.jar"]
