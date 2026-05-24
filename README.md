# Quality Management System

Backend system developed with Java and Spring Boot focused on quality management and inspection control.

The project was created to practice backend development concepts such as REST APIs, layered architecture, database integration and API documentation.

## Project Structure

```bash
src/main/java
├── controller
├── service
├── repository
├── dto
├── entity
├── exception
└── config
```

## Technologies
- Java
- Spring Boot
- PostgreSQL
- JPA/Hibernate
- Swagger/OpenAPI
- Postman

## Features
- Inspection registration
- Search by ID
- Update records
- Delete records

## Running the Project

### Requirements

- Java 17+
- PostgreSQL
- Gradle

### Clone repository

```bash
git clone https://github.com/wel-lopes/quality-management-system.git
```

### Run application

```bash
./gradlew bootRun
```

## API Endpoints
```http
GET /api/inspections
```

## Future Improvements
- JWT authentication
- Docker containerization
- Deploy
- Validation improvements
- Automated tests
