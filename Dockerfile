FROM amazoncorretto:20-alpine-full
WORKDIR /app
COPY build/libs/Student-accounting-0.0.1-SNAPSHOT.jar app.jar
CMD["java", "-jar", "app.jar"]