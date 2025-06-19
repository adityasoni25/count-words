# 📊 Count Words Assignment

## ✅ Problem Statement
A Spring Boot application that processes a list of words to:
- Count the number of words that start with **M** or **m**
- Return all words **longer than 5 characters**

---

## 🏗️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Maven**
- **JUnit 5** (for unit testing)
- **GitHub Actions** (CI/CD & code coverage)
- **Docker** (for containerization)

---

## 🚀 How to Run the Application

### 🔧 Prerequisites
- Java 17+
- Maven 3.6+
- Docker (optional for containerized run)

### 📦 Build and Run Locally

```bash
# Build the application
mvn clean install

# Run the application
mvn spring-boot:run
```

---

## 📄 File Input

The app reads input from a `words.txt` file, located in the `resources` folder.

### 📁 Location
```
src/main/resources/words.txt
```

### ⚙️ Behavior
- The file is bundled inside the application JAR.
- On application startup or when the API is hit, the file is read from the classpath.
- **Changes made to the file after application start will not be reflected unless the application is restarted.**

### 🔄 Alternative for Runtime Updates
To allow dynamic updates (without restart), modify the app to read from an external file using a configurable path in `application.yml`.

---

## 🔗 REST API Usage

### 📥 Endpoint: `/api/process`
- **Method:** GET
- **Description:** Triggers processing of the `words.txt` file and returns results.

#### ✅ Sample Response:
```json
{
  "countStartingWithM": 5,
  "wordsLongerThanFiveChars": [
    "Monkey",
    "Mountain",
    "banana",
    "elephant",
    "momentum",
    "Magnify",
    "matter"
  ]
}
```

---

## 🧪 Testing

To run unit tests:

```bash
mvn test
```

Tests are written using JUnit 5, and coverage is reported through GitHub Actions.

---

## 🐳 Docker Support (Optional)

To build and run with Docker:

```bash
# Build Docker image
docker build -t count-words-app .

# Run container
docker run -p 8080:8080 count-words-app
```

---

## 📚 API Documentation

This project uses [Springdoc OpenAPI](https://springdoc.org/) to generate Swagger-based API documentation.

Once the application is running, you can access the Swagger UI here:

👉 [Swagger UI](http://localhost:8080/swagger-ui/index.html)

You can explore and test the endpoints directly from the browser.

## 📚 Future-Proofing & Extensibility

- Business logic is isolated in a service class, making it easy to extend.
- New rules can be added by modifying or injecting additional service logic.
- Cleanly separated layers for service, controller, and model.
- Configuration externalized in `application.yml`.