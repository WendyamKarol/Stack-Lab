# SPACE BOT PROJECT

## Introduction

The Test & Simulation project aims to create an innovative software solution for controlling and managing a space robot through a centralized supervision system. This robot, designed to carry out missions in a simulated space environment, is remotely controlled via a REST API. The main objective of the project is to optimize automated operations while providing centralized management and real-time supervision of various missions.

## Tools and Technologies

The project utilizes a combination of modern and proven technologies to offer a robust and flexible solution:

- **Language**: Java  
- **Framework**: Spring  
- **Database**: PostgreSQL  
- **Testing**: JUnit, Postman  
- **IDE**: IntelliJ IDEA  

### Technical Details

- **Java**: The primary programming language used in the project. Java was chosen for its robustness, portability, and large community support.
- **Spring**: A popular framework that enables the development of modular and scalable Java applications. Spring simplifies dependency management and the integration of various system components.
- **PostgreSQL**: A relational database used to store information related to robots and missions.
- **JUnit** and **Postman**: Used for unit testing system components and validating REST API endpoints.
- **IntelliJ IDEA**: The chosen integrated development environment (IDE) for its excellent Java support, advanced features, and integration with various development tools.

## Software Architecture

Our solution’s architecture is designed to be modular and scalable. The main components include:

- **Robot**: A physical component integrated into the system to perform automated actions.
- **REST API**: The REST architecture enables standardized communication between the robot and the supervision system. API endpoints facilitate data exchange between the robot and the management interface.
- **Database**: PostgreSQL is used to store information related to missions, robots, and other system entities.
- **Spring**: Used to manage system services, allowing centralized and modular management of various processes.

### Architecture Diagram

The architecture is based on a client-server model where the robot acts as a client that sends data to a server via REST API endpoints. The server processes this data and returns appropriate responses, facilitating the integration of new robots and mission management.

## Unit Testing

### Unit Tests for the `Mission` Class

The `Mission` class is a key entity in our system, describing the characteristics of a mission assigned to a robot. To ensure the robustness and reliability of this class, unit tests have been developed using the **JUnit** framework.

Tests for the `Mission` class include:

- Verification of mission creation with valid attributes.
- Error management tests (e.g., when incorrect data is provided).
- Business logic tests related to mission management.

These tests ensure that all class methods function correctly, verifying that mission attributes are properly initialized and modifications are applied correctly.

## Features

Here are the main features of the **Test & Simulation** project:

### 1. **Mission Creation and Management**
   - Users can create, modify, and track missions assigned to robots.
   - Each mission has specific attributes, such as mission name, robot ID, and objective description.
   - The status of each mission can be updated as it progresses.

### 2. **Robot Supervision**
   - The system allows real-time supervision of robot statuses via a centralized dashboard.
   - Information about each robot, such as its status (active, paused, etc.), positioning, and ongoing missions, is accessible.
   - Alerts can be configured to notify users in case of robot issues.

### 3. **REST API for Integration and Communication**
   - A standardized REST API architecture facilitates communication between the physical robot and the supervision system.
   - The system exposes API endpoints for:
     - **GET**: Retrieve information about robots, missions, and other entities.
     - **POST**: Create new missions or add new robots.
     - **PUT**: Update robot or mission information.
     - **DELETE**: Remove robots or missions.
   - The REST API enables integration with other services or applications in the supervision system.

### 4. **Unit Testing for System Validation**
   - Unit tests have been developed to validate the core system classes, such as the `Mission` class.
   - These tests ensure that business logic functions correctly and that errors are handled properly.
   - The **JUnit** framework is used to automate these tests, ensuring code reliability.

### 5. **API Testing with Postman**
   - REST API endpoints have been tested using **Postman** to ensure that each feature works as expected.
   - Tests include server response verification, error management tests, as well as performance and security tests to guarantee system stability.

### 6. **Mission Simulation**
   - The system allows simulating robot missions before executing them in a real environment.
   - Users can plan and test missions in a controlled environment to ensure they function correctly before deployment.
   - This feature reduces the risk of errors in real missions by simulating different scenarios.

### 7. **Database Management**
   - A PostgreSQL database is used to store all information related to robots, missions, users, and other system entities.
   - Database management is done via **JPA (Java Persistence API)**, enabling efficient data management and seamless integration with the application.
   - Database entities are linked to different Java classes in the project, simplifying data manipulation and relationship management.

### 8. **Supervision Dashboard**
   - A visual dashboard allows users to monitor robot and mission statuses in real-time.
   - Users can view charts and statistics on robot performance, mission progress, and other key indicators.
   - This dashboard aids decision-making by providing a clear and detailed overview of ongoing operations.

### 9. **Extensibility and Scalability**
   - The system is designed to be easily extensible, allowing new features and new robots to be added at any time.
   - The modular architecture supports the addition of new services, management of new mission types, and integration with other systems via the REST API.
   - Update management is simplified, ensuring the system remains flexible to technological advancements and new user needs.

### 10. **Robot Status Monitoring**
   - The system enables real-time monitoring of robot statuses through performance indicators and status reports.
   - Monitoring includes data such as robot location, battery level, operational status, and ongoing missions.
   - Alerts can be triggered when anomalies are detected in robot operations.

These features make our solution a comprehensive and robust platform for efficiently and centrally managing autonomous robots and their missions.
