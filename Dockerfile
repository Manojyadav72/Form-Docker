##Write a Dockerfile to build a JSP-CRUD application
FROM openjdk:11-jdk-slim
# Set the working directory 
WORKDIR /app

# Copy the application files to the container
COPY . /app


# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/* 

# Build the application using Maven
RUN mvn clean package

# Expose the port the application runs on
EXPOSE 8080

# Set the entry point to run the application
CMD ["java", "-jar", "target/jsp-crud-1.0-SNAPSHOT.jar"]









