# GlobalWallet Microservices

GlobalWallet is a distributed fintech backend system that supports multi-currency wallets, transactions, and real-time exchange rate updates using a microservices architecture.

---

## 🚀 Tech Stack

- Java, Spring Boot
- PostgreSQL
- Python (Automation Worker)
- Docker & Docker Compose
- REST APIs

---

## 🧠 Architecture

- **User Service** → Manages users and wallets  
- **Transaction Service** → Handles money transfers and currency conversion  
- **Python Worker** → Updates exchange rates from external APIs  
- **PostgreSQL** → Central database  

---

## ⚙️ Features

- Multi-currency wallet support  
- Real-time transaction processing  
- Inter-service communication using REST  
- Automated exchange rate updates  
- Containerized deployment using Docker  

---

## 🐳 Running the Project

```bash
docker compose up --build
