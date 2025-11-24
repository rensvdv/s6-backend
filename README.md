# s6-backend
# Backend – Microservices + API Gateway

Dit project bestaat uit meerdere Spring Boot services die samen een kleine microservices-architectuur vormen. De backend bestaat uit:

* **API Gateway (Spring Cloud Gateway)** – routering naar services
* **Music Service** – CRUD voor muziek/albums
* **Recommendation Service** – aanbevelingen
* **Kafka Setup** – Dockerfile of docker-compose voor Kafka en Zookeeper

De services draaien afzonderlijk maar vormen samen de backend omgeving.

---

## 📁 Projectstructuur

```
backend/
  api-gateway/
  music-service/
  recommendation-service/
  kafka/
    Dockerfile of docker-compose.yml
```

---

## 🚀 Services starten

### 1. **Kafka starten (vereist)**

Ga naar de kafka-folder:

```bash
cd kafka
```

Als er een docker-compose.yml staat:

```bash
docker compose up -d
```

Of gebruik de Dockerfile:

```bash
docker build -t kafka-setup .
docker run -p 9092:9092 kafka-setup
```

Zorg dat Kafka draait op **localhost:9092**.

---

### 2. **API Gateway starten**

```bash
cd api-gateway
./mvnw spring-boot:run
```

* Draait op: **[http://localhost:8080](http://localhost:8080)**

---

### 3. **Music Service starten**

```bash
cd music-service
./mvnw spring-boot:run
```

* Draait op: **[http://localhost:8081](http://localhost:8081)**

---

### 4. **Recommendation Service starten**

```bash
cd recommendation-service
./mvnw spring-boot:run
```

* Draait op: **[http://localhost:8082](http://localhost:8082)**

---

## 🔀 Routing via Gateway

| Endpoint                  | Route          | Gaat naar              |
| ------------------------- | -------------- | ---------------------- |
| `/api/music/**`           | gateway → 8081 | Music Service          |
| `/api/recommendations/**` | gateway → 8082 | Recommendation Service |

De gateway gebruikt WebFlux, dus CORS is geconfigureerd via een `CorsWebFilter`.

---

## 🧪 Testen

Gebruik Postman of curl:

```bash
curl http://localhost:8080/api/music
```

---

## 🛠 Technologieën

* Spring Boot
* Spring Cloud Gateway (WebFlux)
* Spring JPA + H2
* Kafka
* Docker

---

## 📌 Opmerking

Alle communicatie tussen frontend en services moet via de gateway verlopen:

```
http://localhost:8080/api/...
```

Dit voorkomt CORS-problemen en houdt de architectuur proper.
