FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
EXPOSE 8080
CMD  ["java", "-jar", "target/dslist-0.0.1-SNAPSHOT.jar"]

