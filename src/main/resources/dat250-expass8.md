# DAT250 - expass 8

## Example 1

In this example, I successfully installed Docker. I pulled the PostgreSQL via docker, once it was up and running in its container, I made necessary modifications to my existing application to ensure compatibility with the containerized PostgreSQL database. 

Link to the repository: [GitHub Repository](https://github.com/magddzi881/dat250-jpa-tutorial)


![image](https://github.com/user-attachments/assets/1e53221a-07bb-40aa-8794-cd692232d2b6)
![image](https://github.com/user-attachments/assets/f43e8f18-37e7-46ff-a768-fd9a24a409c2)
  


## Example 2

Link to the repository: [GitHub Repository](https://github.com/magddzi881/250-lab2)

In this example i added Dockerfile to my project with code:

```dockerfile
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


