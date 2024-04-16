# Reminder Documentation
This document describes the documentation of the "Reminder" microservice utilizing Spring Boot and Java technologies, 
following the hexagonal architecture for separation of concerns.

## Swagger Documentation
OpenAPI Specification: [link to the Swagger documentation for the Reminder Backend]

## AsyncAPI Documentation
AsyncAPI Specification: [link to the AsyncAPI documentation for the Reminder Backend]

## Hexagonal Architecture
    The hexagonal architecture (or ports and adapters) is used to separate the concerns of the application into different 
    layers, facilitating maintenance, testing, and evolution of the system.

# Solution Design:

## Domain Layer:
    Defines the reminder models (Reminder), interfaces, and domain services.

## Application Layer:
    Implements use cases (Use Cases) orchestrating business logic.

## Infrastructure Layer:
    Implements adapters for persistence (ReminderRepository) and for external APIs (notifications, integrations).

# Technologies Used

## Spring Boot:
    Used to implement the backend with dependency injection and agile development.

## Docker:
    Containerizes each microservice to facilitate packaging and deployment.

## Kubernetes:
    Orchestrates Docker containers for scalability management, monitoring, and load balancing.

## Linux:
    Operating system used to host the services.

## AWS:
    Utilizes services like EC2, RDS, S3 for cloud infrastructure.

## RESTful APIs:
    Defines APIs for communication between services and with the frontend.

---
# Scalability and Monitoring
## Scalability:
Scales horizontally using Kubernetes to add more service instances as needed.

## Monitoring:
Utilizes tools like Prometheus, Grafana to monitor performance metrics and service health.

---
# Fault Tolerance and Database
    Implements resilience strategies such as circuit breakers (using Hystrix) and retries.

## Database:
    Utilizes NoSQL databases like MongoDB for flexibility and scalability in unstructured data schemas.

## Schema Flexibility:
    Easily handles data without a defined structure, ideal for reminders with different fields or metadata.

## Horizontal Scalability:
    Capable of scaling easily with large volumes of data and workload.

---
# Handling Large Data Loads and Asynchronicity
    Uses techniques like data partitioning, caching, and efficient indexing.

## Asynchronicity:
    Implements asynchronous tasks for operations that do not require an immediate response, such as sending notifications.
    CI/CD, Logs, and API Gateway

## CI/CD Pipelines:
    Automates the process of continuous integration and delivery using Jenkins, GitLab CI, or similar tools.

## Logs:
    Utilizes tools like ELK Stack (Elasticsearch, Logstash, Kibana) to centralize and analyze logs.

## API Gateway:
    Implements a gateway to manage inbound/outbound traffic, security, and API monitoring.