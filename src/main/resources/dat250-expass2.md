# DAT250-ExpAss2 Report

## Overview
The objective of this assignment was to create a simple REST API for a PollApp using Spring Boot, which supports CRUD operations for the main domain entities: `User`, `Poll`, `VoteOption`, and `Vote`.

## Step 1: Domain Model
I implemented the initial draft of the PollApp domain model in Java, following the provided diagram. Each domain entity (`User`, `Poll`, `VoteOption`, and `Vote`) was designed as a Java Bean with public constructors, getters, and setters. The `PollManager` class was introduced to manage the entities in memory using `HashMap`s, and it was annotated with `@Component`.

### Technical Challenges
One minor challenge during this step was maintaining the relationships between the entities. For example, I had to ensure that a `User` could have a list of `Polls` they created and a list of `Votes` they cast, and that the `Vote` would reference both a `User` and a `VoteOption`. This was resolved by careful modeling of associations and using `Set` collections to manage these relationships.

## Step 2: Implement Test Scenarios
Following the test-driven approach, I designed several test scenarios, primarily using Postman as the HTTP client for manual testing. These tests covered:
- Creating new users and listing all users.
- Creating new polls.
- Casting and updating votes.
- Ensuring that votes are properly associated with users.
- Deleting a poll and verifying that related votes were also deleted.

## Step 3: Automate Testing
In addition to using Postman for manual testing, I also wrote automated integration tests. These tests were implemented in the `test` folder of the project.

## Step 4: API Documentation
I successfully integrated **Springdoc OpenAPI** to generate API documentation. After adding the required dependencies to `build.gradle.kts`, I accessed the API documentation through `http://127.0.0.1:8080/swagger-ui.html`. The generated documentation correctly reflected the API endpoints and their respective request/response formats.

## Step 5: Build Automation (Pending)
I have not yet implemented build automation via GitHub Actions.

