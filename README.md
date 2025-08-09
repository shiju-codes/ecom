# ShopBean

This is a Spring Boot-based e-commerce backend designed to handle core functionalities of an online store. The system is built using a microservices architecture, leveraging multiple technologies to ensure scalability, reliability, and observability.

## Technologies Used

- **Spring Boot**: Core framework for building the microservices-based backend.
- **Spring API Gateway**: Centralized entry point for routing requests to appropriate microservices.
- **Eureka Server**: Service registry for discovering and managing microservices.
- **Zipkin**: Distributed tracing system for monitoring and troubleshooting.
- **Prometheus**: Monitoring and alerting toolkit for collecting metrics.
- **Micrometer**: Metrics instrumentation library for integrating with Prometheus.
- **MySQL**: Relational database for core data storage.
- **MongoDB**: NoSQL database used in the audit microservice for logging and tracking.
- **Kafka**: Messaging queue for asynchronous communication between microservices.
- **Feign Client**: Declarative REST client for making API calls between microservices.
- **Apache Camel**: Framework for processing feeds and integrating with external systems.

## Project Structure

The backend is organized into multiple microservices, each handling specific business functionalities (e.g., product catalog, user management, order processing, audit logging). The services communicate via Kafka for asynchronous messaging and Feign Client for synchronous API calls. The Spring API Gateway routes incoming requests, while Eureka Server ensures service discovery. Monitoring is handled by Zipkin for tracing and Prometheus with Micrometer for metrics.

## Setup Instructions

### Prerequisites

- Java 17 or higher
- Maven
- MySQL
- MongoDB
- Kafka
- Zipkin
- Prometheus
- Docker (optional for containerized deployment)

## Future Enhancements

- Add authentication and authorization using Spring Security.
- Implement CI/CD pipelines for automated deployment.
- Expand monitoring with Grafana for visualization.
- Add more microservices as needed (e.g. inventory).

## Contributing

Contributions are welcome! Please fork the repository, create a feature branch, and submit a pull request with your changes.

## License

This project is licensed under the MIT License.
