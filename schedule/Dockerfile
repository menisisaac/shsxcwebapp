FROM openjdk:18
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
Expose 3000
CMD ["./mvnw", "spring-boot:run"]
