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

## Fill in example data

cat > befuellen.sh << 'EOF'
BASE="https://price-compare-production-1a55.up.railway.app/products"

curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "iPhone 15 Pro", "category": "Handy", "price": 1199.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "iPhone 15", "category": "Handy", "price": 999.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Samsung Galaxy S24 Ultra", "category": "Handy", "price": 1299.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Samsung Galaxy S24", "category": "Handy", "price": 849.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Google Pixel 8 Pro", "category": "Handy", "price": 1099.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Google Pixel 8", "category": "Handy", "price": 699.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "OnePlus 12", "category": "Handy", "price": 799.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "MacBook Pro 14 M3", "category": "Laptop", "price": 2499.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "MacBook Air M2", "category": "Laptop", "price": 1299.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Dell XPS 13", "category": "Laptop", "price": 1399.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Lenovo ThinkPad X1 Carbon", "category": "Laptop", "price": 1599.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "ASUS ROG Zephyrus G14", "category": "Laptop", "price": 1799.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "HP Spectre x360", "category": "Laptop", "price": 1499.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Sony WH-1000XM5", "category": "Kopfhoerer", "price": 349.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "AirPods Pro 2", "category": "Kopfhoerer", "price": 279.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Bose QuietComfort 45", "category": "Kopfhoerer", "price": 299.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Samsung Galaxy Buds2 Pro", "category": "Kopfhoerer", "price": 199.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Jabra Evolve2 85", "category": "Kopfhoerer", "price": 449.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "iPad Pro 12.9", "category": "Tablet", "price": 1299.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "iPad Air M1", "category": "Tablet", "price": 749.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Samsung Galaxy Tab S9", "category": "Tablet", "price": 849.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Microsoft Surface Pro 9", "category": "Tablet", "price": 1199.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Kfz-Haftpflicht Basic", "category": "Versicherung", "price": 49.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Kfz-Vollkasko Premium", "category": "Versicherung", "price": 149.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Hausratversicherung Standard", "category": "Versicherung", "price": 89.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Krankenversicherung Basis", "category": "Versicherung", "price": 299.99}'
curl -X POST $BASE -H "Content-Type: application/json" -d '{"name": "Reiseversicherung Europa", "category": "Versicherung", "price": 29.99}'
EOF

chmod +x befuellen.sh
./befuellen.sh
