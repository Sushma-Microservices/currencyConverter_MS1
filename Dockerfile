FROM openjdk:8
ADD target/currencyConversion_MS1-0.0.1-SNAPSHOT.jar currencyConversion_MS1-0.0.1-SNAPSHOT.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "currencyConversion_MS1-0.0.1-SNAPSHOT.jar"]