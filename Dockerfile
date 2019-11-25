FROM openjdk:8-alpine

COPY target/uberjar/excelman.jar /excelman/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/excelman/app.jar"]
