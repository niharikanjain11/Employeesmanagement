# Employee Management System

This is a Spring Boot-based Employee Management System with the following features:
- CRUD operations for employee entities
- H2 in-memory database for development and testing
- MapStruct for DTO mapping
- Spring Security for securing API endpoints
- Integration with Swagger for API documentation

---

## Technologies Used

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database**
- **MapStruct**
- **Spring Security**
- **Swagger (SpringDoc OpenAPI)**
- **Maven**

---

## Prerequisites

- Java 17 or later
- Maven 3.x
- IDE (Eclipse/IntelliJ)

---

## Getting Started

1. **Clone the Repository**
    ```bash
    git clone https://github.com/your-username/employee-management.git
    cd employee-management
    ```

2. **Build the Project**
    ```bash
    mvn clean install
    ```

3. **Run the Application**
    ```bash
    mvn spring-boot:run
    ```

4. **Access the Application**
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Configuration

### application.properties
The configuration for the H2 database is defined in `src/main/resources/application.properties`:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect

# API Endpoints
GET /api/employees - Get all employees
GET /api/employees/{id} - Get employee by ID
POST /api/employees - Create a new employee
PUT /api/employees/{id} - Update an existing employee
DELETE /api/employees/{id} - Delete an employee

# Testing the API with Postman
1. Get All Employees
Method: GET
URL: http://localhost:8080/api/employees
2. Get Employee by ID
Method: GET
URL: http://localhost:8080/api/employees/{id}
3. Create a New Employee
Method: POST
URL: http://localhost:8080/api/employees
Body (JSON):
json
Copy
Edit
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
4. Update an Employee
Method: PUT
URL: http://localhost:8080/api/employees/{id}
Body (JSON):
json
Copy
Edit
{
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane.doe@example.com"
}
5. Delete an Employee
Method: DELETE
URL: http://localhost:8080/api/employees/{id}
MapStruct Configuration
This project uses MapStruct for mapping between DTOs and entities.

# Dependency in pom.xml:
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.5.5.Final</version>
</dependency>

<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>1.5.5.Final</version>
    <scope>provided</scope>
</dependency>
Enable Annotation Processing:

In Eclipse: Go to Window → Preferences → Java → Compiler → Annotation Processing and enable it.
In IntelliJ: Go to File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors and enable it.
#H2 Database Console
#You can access the H2 database console at:

URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

#This project uses SpringDoc OpenAPI for documenting the APIs. You can access the Swagger UI at:

URL: http://localhost:8080/swagger-ui.html

Author
Niharika N Jain
Application Developer at IBM
