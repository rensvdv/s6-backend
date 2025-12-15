# s6-backend
# Backend – Microservices + API Gateway

Dit project bestaat uit meerdere Spring Boot services die samen een kleine microservices-architectuur vormen. De backend bestaat uit:

* **API Gateway (Spring Cloud Gateway)** – routering naar services
* **Music Service** – CRUD voor muziek/albums
* **Recommendation Service** – aanbevelingen

De services draaien afzonderlijk maar vormen samen de backend omgeving.

---

## Projectstructuur

```
backend/
  api-gateway/
  music-service/
  recommendation-service/
 
```

---

### **Services**

De services communiceren met elkaar via Apache Kafka, specifiek de Docker image van Kafka Native 4.1.1 (https://hub.docker.com/layers/apache/kafka-native/4.1.1), De Music-service is de publisher en de Rec-service is de subsrciber.

#### api-gateway
* Draait op: **[http://localhost:8080](http://localhost:8080)**

---

#### music-service
* Draait op: **[http://localhost:8081](http://localhost:8081)**

---

#### rec-service
* Draait op: **[http://localhost:8082](http://localhost:8082)**

---

