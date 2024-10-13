# DAT250 - expass 8

## Example 1

In this example, I successfully installed Docker. I pulled the PostgreSQL via docker, once it was up and running in its container, I made necessary modifications to my existing application to ensure compatibility with the containerized PostgreSQL database. 

Link to the repository: [GitHub Repository](https://github.com/magddzi881/dat250-jpa-tutorial)


![image](https://github.com/user-attachments/assets/1e53221a-07bb-40aa-8794-cd692232d2b6)
![image](https://github.com/user-attachments/assets/f43e8f18-37e7-46ff-a768-fd9a24a409c2)
  


## Example 2

In this example i added Dockerfile to my project with code:

```dockerfile
# Stage 1: Build the application
FROM gradle:7.6-jdk17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Copy the source code into the container
COPY src/ src/

# Build the application
RUN ./gradlew bootJar

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk

# Set the working directory for the final image
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Create a non-root user to run the application
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup

# Change the owner of the JAR file to the non-root user
RUN chown appuser:appgroup app.jar

# Switch to the non-root user
USER appuser

# Expose the application's port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]

