# 📚 BookApplication

A simple **Spring Boot 3** project that exposes a CRUD **REST API** for managing books.  
It uses **Spring Data JPA**, **H2 in-memory DB**, **Lombok**, **MapStruct**, and a **global exception handler** that returns clean JSON error responses.

---

## ✨ Features
- Create, read, update, delete books (CRUD)
- DTO layer with **MapStruct** mapping
- Global error handling with consistent JSON responses
- H2 in-memory database (no external DB needed)
- Ready for **Java 21** and Maven

---

## 🧰 Tech Stack
- Java 21, Spring Boot 3 (Web, Data JPA)
- H2 + HikariCP
- Lombok, MapStruct
- Maven

---

## 🚀 Quick Start

```bash
# run in dev mode
mvn spring-boot:run

# or build & run the jar
mvn clean package -DskipTests
java -jar target/BookApplication-0.0.1-SNAPSHOT.jar
