FROM openjdk:18
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
EXPOSE 8081
CMD ["./mvnw", "spring-boot:run"]
