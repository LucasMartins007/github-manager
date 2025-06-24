FROM eclipse-temurin:23-jdk AS builder

RUN apt-get update && apt-get install -y maven

RUN java -version && mvn -version

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


FROM eclipse-temurin:23-jdk

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]