# FNOL Claims Routing – Using Spring Boot

## Description
This project is a Spring Boot REST API that processes FNOL (First Notice of Loss) data and routes insurance claims based on predefined business rules.

The application extracts claim details, checks for missing information, and determines the appropriate processing route with an explanation.

---

## Technologies Used
- Java 17
- Spring Boot
- Spring Web
- Bean Validation
- Maven
- Postman

---

## Routing Rules
Claims are routed based on the following priority:
1. Manual Review – Missing or blank mandatory fields
2. Investigation Flag – Fraud-related keywords in description
3. Specialist Queue – Injury-related claims
4. Fast-track – Estimated damage below 25,000

---

## API Endpoint
**POST** `/api/claims/process`

---

## How to Run
1. Clone the repository
2. Import as Maven project
3. Run `SynapxApplication.java`
4. Test API using Postman at `http://localhost:8080` or `http://localhost:8080/api/claims/process`

---

## Sample Response
The API returns extracted fields, missing fields, routing decision, and reasoning.

---

## Author
Jeevan Kumar
