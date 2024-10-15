# Use an image with JDK 21
FROM eclipse-temurin:21-jdk AS build

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy necessary files to the container (gradle scripts and project files)
COPY build.gradle.kts settings.gradle.kts gradlew /app/
COPY gradle /app/gradle
COPY src /app/src

# Step 4: Run the Gradle build task to create the bootable JAR file
RUN ./gradlew bootJar

# Step 5: Use a minimal JDK 21 image to run the app
FROM eclipse-temurin:21-jdk-alpine AS run

# Step 6: Set the working directory
WORKDIR /app

# Step 7: Copy the built jar file from the build stage into the run stage
COPY --from=build /app/build/libs/*.jar app.jar

# Step 8: Expose port 8080 (default port for Spring Boot)
EXPOSE 8080

# Step 9: Define the command to run the application
CMD ["java", "-jar", "app.jar"]
