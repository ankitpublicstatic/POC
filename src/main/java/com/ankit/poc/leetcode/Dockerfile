# build stage
FROM maven:3.9.1-eclipse-temurin-17 as builder
WORKDIR /app
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN mvn -B -f pom.xml dependency:go-offline

COPY src ./src
RUN mvn -B -f pom.xml package -DskipTests

# runtime
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV PORT=8080
ENTRYPOINT ["java","-Xms512m","-Xmx512m","-jar","/app/app.jar"]
