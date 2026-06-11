# Price Compare API

A small REST API built with Spring Boot and MongoDB. I built this project to learn 
and practice Java backend development with the Spring ecosystem.

## What it does

Provides a simple product management API where you can create, retrieve and delete 
products. Products have a name, category and price.

## Tech Stack

- Java 21
- Spring Boot 3.5
- MongoDB
- Gradle
- Docker (for local MongoDB)

## Getting Started

Make sure you have Docker running, then start MongoDB:

```bash
docker run -d --name mongodb -p 27017:27017 mongo:7
```

Then run the app:

```bash
./gradlew bootRun
```

The API is available at `http://localhost:8080`.

## Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /products | Get all products |
| GET | /products/{id} | Get product by ID |
| GET | /products/category/{category} | Get products by category |
| POST | /products | Create a product |
| DELETE | /products/{id} | Delete a product |

## Example

Create a product:
```bash
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name": "iPhone 15", "category": "Handy", "price": 999.99}'
```

## Tests

Unit tests with Mockito and integration tests with Testcontainers:

```bash
./gradlew test
```
