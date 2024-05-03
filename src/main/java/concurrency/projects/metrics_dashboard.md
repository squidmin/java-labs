# Metrics Dashboard project

Develop a real-time dashboard for monitoring and managing system or application metrics.
This project could be particularly effective in demonstrating utilization of concurrency techniques within a real-world Spring Boot application.
Below is a detailed outline of this project:

## Project Overview

### Real-Time Metrics Dashboard Backend

**Objective**: Develop a RESTful API that collects, processes, and streams real-time metrics from various sources (e.g., server health, application performance, user activities).
The frontend will display these metrics dynamically, updating in real-time as new data arrives.

## Key Features

1. **Data Collection**: Accept data from various sources. This could involve direct inputs from other microservices or scheduled fetching from external APIs.
2. **Real-Time Processing**: Use concurrent processing to handle incoming data streams efficiently.
   This can involve calculating averages, detecting anomalies, or aggregating statistics in real-time.
3. **WebSocket Communication**: Implement a WebSocket endpoint that the frontend can subscribe to, allowing real-time data pushing from the backend to the frontend.
4. **Data Persistence**: Store historical data using a database, which can be queried via REST endpoints to fetch historical metrics.
5. **Concurrency Management**: Utilize Java's concurrency utilities to manage multiple threads, ensuring data integrity and performance.
6. **Security**: Implement basic authentication or JWT-based security to manage access to the API and the WebSocket stream.

## Technologies

- **Backend**: Spring Boot 3 for creating RESTful services, integrating WebSocket for real-time communication, and using Spring Data for database interactions.
- **Concurrency**: Java's ExecutorService for handling asynchronous tasks, Atomic classes for safe counter operations, and CompletableFuture for non-blocking operations.
- **Database**: Choose an appropriate database like PostgreSQL or MongoDB, depending on the nature of data and querying needs.
- **Testing**: JUnit 5 for unit testing, Mockito for mocking dependencies, and Spring's testing support to simulate concurrent access and load testing.
- **Build Tool**: Gradle 8 for managing dependencies, building, and testing the application.
- **Frontend**: A simple React or Angular application that uses WebSocket to receive real-time updates and displays data using chart libraries like Chart.js or D3.js.

## Development Steps

1. **Setup Project**: Initialize a Spring Boot project with necessary dependencies using Gradle.
2. **Define Data Model**: Create models for handling metrics data.
3. **Implement RESTful API**: Develop API endpoints for posting and fetching metrics data.
4. **Concurrency Implementation**: Implement services to handle data concurrently, ensuring thread safety.
5. **WebSocket Setup**: Establish a WebSocket channel for pushing updates to the frontend.
6. **Frontend Development**: Build a basic frontend application to display real-time data.
7. **Testing**: Write comprehensive tests to ensure functionality and concurrency safety.
8. **Documentation**: Document the API and setup instructions.

## Real-Life Application

This project could be used by system administrators to monitor server metrics, by software developers to track application performance in production, or by business analysts to monitor real-time user interaction data.
It showcases your ability to integrate modern backend technologies with frontend frameworks and to apply complex concurrency models in a practical, user-friendly application.

## Mock Data Service

If real metrics data isn't readily available, creating a mock data service for system metrics is an excellent idea to demonstrate backend skills while not depending on real-world data sources.
This setup allows you to control the data flow, test various scenarios, and show how the system handles concurrent data processing and real-time communication without requiring access to actual system metrics.
Here's how you can implement this:

## Project Setup and Configuration

1. **Spring Boot Project**: Initialize a Spring Boot project with dependencies for Web, Security, WebSocket, and JPA (if you plan to store metrics data).
2. **Mock Service Implementation**: Develop a service in Spring Boot that generates mock data. This service can simulate different metrics like CPU utilization, memory usage, and network stats.
3. **REST API**: Create RESTful endpoints to fetch current system metrics and to subscribe to real-time updates via WebSocket.

## Mock Data Generation

To simulate real-time system metrics, the mock service could generate data based on random values or predefined patterns.
Here’s a basic approach to structure this:

### `MockService.java`

```java
import java.util.Random;

public class MockService {
    private final Random random = new Random();

    public double getCpuUtilization() {
        return 50 + random.nextDouble() * 50;  // Random CPU utilization between 50-100%
    }

    public double getMemoryUtilization() {
        return 30 + random.nextDouble() * 70;  // Random memory utilization between 30-100%
    }

    public double getStorageUtilization() {
        return 10 + random.nextDouble() * 90;  // Random storage utilization between 10-100%
    }

    public double getNetworkUtilization() {
        return 20 + random.nextDouble() * 80;  // Random network utilization between 20-100%
    }
}
```

## REST Controller and WebSocket

Implement a controller to expose the REST API and WebSocket endpoint that provides real-time updates of the metrics.

### `MetricsController.java`

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@RestController
@EnableWebSocketMessageBroker
public class MetricsController {

    @Autowired
    private MockService mockService;

    @GetMapping("/api/metrics")
    public Metrics getMetrics() {
        return new Metrics(
            mockService.getCpuUtilization(),
            mockService.getMemoryUtilization(),
            mockService.getStorageUtilization(),
            mockService.getNetworkUtilization()
        );
    }

    @MessageMapping("/metrics")
    @SendTo("/topic/metrics")
    public Metrics sendRealTimeMetrics() {
        // Method to send metrics to subscribed clients via WebSocket
        return getMetrics();
    }
}
```

## Frontend

Develop a simple frontend application using React or Angular that displays these metrics in real-time.
Use libraries like Socket.IO or SockJS for handling WebSocket connections.

## Testing

Write unit tests for your services and integration tests for your API endpoints.
Utilize JUnit 5 and Mockito to mock dependencies and test the functionality of your application thoroughly.

## Conclusion

This project not only showcases your backend skills with Spring Boot but also demonstrates your understanding of real-time data processing, WebSockets, REST API design, and concurrent data handling in a modern application context.
It's a comprehensive demonstration of your ability to create a full-stack application from the ground up.
