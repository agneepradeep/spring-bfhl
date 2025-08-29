# 🟢 Spring Boot BFHL Project

A **Spring Boot REST API** for the Backend For Human Logic (BFHL) assignment.
It processes input data into **numbers, alphabets, and special characters**, computes sums, and builds a concatenated string with alternating cases.

---

## ⚡ Tech Stack

* **Java 17**
* **Spring Boot 3.x**
* **Maven**
* **REST API (JSON)**
* Optional: **Docker support**

---

## 📂 Project Structure

```
spring-bfhl/
 ├── src/main/java/com/example/spring_bfhl/
 │   ├── controller/   # REST Controller
 │   ├── dto/          # Request & Response DTOs
 │   └── service/      # Business Logic
 ├── pom.xml           # Maven dependencies
 └── README.md         # Project documentation
```

---

## ▶️ Run Locally

### 1. Clone Repo

```bash
git clone https://github.com/<your-username>/spring-bfhl.git
cd spring-bfhl
```

### 2. Build

```bash
./mvnw clean package -DskipTests
```

### 3. Run

```bash
./mvnw spring-boot:run
```

App runs at:
👉 `http://localhost:8080`

---

## 📡 API Endpoints

### **1. POST /bfhl**

Process data array.

**Request**

```json
{
  "data": ["12a", "3.14", "-7", "Hello", "!", " "]
}
```

**Response**

```json
{
  "is_success": true,
  "user_id": "agneepradeep_verma_19062002",
  "email": "agnipradeep19@gmail.com",
  "roll_number": "22BCI0198",
  "odd_numbers": [],
  "even_numbers": [],
  "alphabets": ["HELLO"],
  "special_characters": ["12a", "3.14", "-7", "!", " "],
  "sum": "0",
  "concat_string": "OlLeH"
}
```

---

## 🛠️ Improvements

* Add **input validation** & error handling
* Dockerize with a simple `Dockerfile`
* Deploy on **Heroku / AWS Elastic Beanstalk / Render** for free hosting

---

## 👨‍💻 Author

* **Agnipradeep Verma**
* 📧 [agnipradeep19@gmail.com](mailto:agnipradeep19@gmail.com)
* 🎓 Roll No: 22BCI0198

---
