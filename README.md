# URL Shortener

![Java 21](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![HTML/CSS/JS](https://img.shields.io/badge/HTML%20%2F%20CSS%20%2F%20JS-E34F26?style=for-the-badge&logo=javascript&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2%20Database-3178C6?style=for-the-badge&logo=databricks&logoColor=white)

A fast, lightweight URL shortener built to quickly convert long web addresses into manageable, trackable links.

---

## About the Project
* **Unique Code Generation:** Uses Java UUID to uniquely generate a short code for each URL.
* **Instant Redirection:** Catches dynamic short codes and fires HTTP 302 responses to route users seamlessly.
* **Robust Validation:** Implements Jakarta Validation to ensure database integrity and reject malformed inputs before they hit the server.
* **Zero-Config Setup:** Uses an embedded H2 database, making it incredibly easy for other developers to clone, compile, and run the project locally in seconds.
* **Automated Documentation:** Integrated OpenAPI (Swagger) specification.

## Tech Stack
* **Backend:** Java 21, Spring Boot 4.0.6
* **Frontend:** HTML/CSS/JavaScript
* **Database:** H2 In-memory database
* **Build Tool:** Maven

## API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | /shorten | Generate short code for a URL and add it to the database |
| `GET` | /{code} | Redirect to the URL that matches the given short code |
| `GET` | /all | Return all short codes attached to their corresponding URLs |

## How To Run Locally

**Prerequisites:**
* Java 21+ (https://www.oracle.com/java/technologies/downloads/)
* Maven (https://maven.apache.org/download.cgi)
* Git (https://git-scm.com/install/)

**1. Clone the repo from your terminal or command prompt**
```
git clone https://github.com/zachprogramming1684/URL-Shortener.git
```

**2. Navigate to the cloned repository**
```
cd URL-Shortener
```

**3. Build and run the project**  

*Windows (Command Prompt):*  
```
mvnw spring-boot:run
```
*MacOS/Linux:*
```
mvn spring-boot:run
```

**4. Access the project**  
You can access the project in your browser at `localhost:8080`.  
You can access the API endpoints at `localhost:8080/swagger.api`.  
You can access all of your created short links at `localhost:8080/all`  
Simply press `Ctrl + C` in your terminal to terminate the program.  
