# Spring Boot Patient API

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)
![Java](https://img.shields.io/badge/java-17-orange)
![Spring Boot](https://img.shields.io/badge/springboot-3.2-green)

## 📊 Overview
Demo REST API for patient records using Spring Boot. Showcases secure backend design and healthcare domain expertise.

## 🛠️ Tech Stack
- Java
- Spring Boot
- RESTful APIs

## 🚀 Features
- Add patient records
- Retrieve patient records by ID
- Simple in-memory storage for demo purposes

## ⚡ Quickstart
```bash
mvn clean package -DskipTests
java -jar target/patient-api.jar

## 📂 Repository Structure
springboot-patient-api/
├── src/
│   ├── main/
│   │   └── java/com/aronbariagabr/patientapi/
│   │       ├── controller/PatientController.java
│   │       ├── model/Patient.java
│   │       └── service/PatientService.java
│   └── test/
│       └── java/com/aronbariagabr/patientapi/controller/
│           └── PatientControllerTest.java
├── pom.xml
└── README.md

## 🏗️ Architecture Diagram (Box Style)

+----------------------+
|      Client App      |
| (curl / Postman / UI)|
+----------------------+
           |
           v
+----------------------+
|  PatientController   |
| - Handles HTTP req   |
| - Maps endpoints     |
+----------------------+
           |
           v
+----------------------+
|   PatientService     |
| - Business logic     |
| - Stores patients    |
| - Retrieves patients |
+----------------------+
           |
           v
+----------------------+
|    Patient Model     |
| - id, name, age      |
| - Data representation|
+----------------------+
           |
           v
+----------------------+
|      Response        |
| - JSON output        |
| - Sent to client     |
+----------------------+


## 🔄 Workflow
1.Client sends request (POST /patients or GET /patients/{id}).
2.PatientController receives and validates the request.
3.PatientService executes business logic (store/retrieve patient).
4.Patient model represents the data.
5.Response returned to client.

## 📡 API Endpoints
POST /patients → Add a new patient
GET /patients/{id} → Retrieve patient by ID

## Example Usage
curl -X POST http://localhost:8080/patients \
     -H "Content-Type: application/json" \
     -d '{"id":1,"name":"Alice","age":30}'

curl -X GET http://localhost:8080/patients/1

## 🧪 Testing
Run unit tests with:
mvn test

## 📝 Future Work

+-------------------------------------------+
|               FUTURE WORK                 |
+-------------------------------------------+
| • Integrate with relational database      |
|   (PostgreSQL / MySQL)                    |
| • Add Dockerfile & Docker Compose         |
|   for containerized deployment            |
| • Implement PatientRepository with JPA    |
| • Add validation & error handling         |
| • Expand API with update/delete endpoints |
| • Secure endpoints with Spring Security   |
+-------------------------------------------+
