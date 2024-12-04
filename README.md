# Quiz App

The **Quiz App** is a Spring Boot-based RESTful application designed to manage quizzes. It allows users to attempt questions, track their scores, and view their performance.

## Features

- **User Dashboard**: View quiz statistics such as total questions attempted, correct answers, and score percentage.
- **Take Quiz**: Fetch random questions from the database.
- **Submit Answer**: Validate answers and update user statistics.
- **End Quiz**: Finalize quiz and display user results.
- **Exception Handling**: Graceful error handling with appropriate messages.

---

## Project Structure

### Models
- **QuizUser**: Represents a quiz user with attributes like name, total questions attempted, correct answers, and score.
- **Question**: Stores quiz questions with options (A, B, C, D) and the correct answer.

### Controllers
- **QuizController**: REST API endpoints for quiz operations such as fetching questions, submitting answers, and ending quizzes.

### Services
- **QuizService**: Business logic for user operations, question retrieval, and answer validation.

### Repositories
- **UserRepository**: Handles database operations for `QuizUser`.
- **QuestionRepository**: Handles database operations for `Question`.

### Exception Handling
- **ExceptionHandlerAdvice**: Centralized exception handling using `@ControllerAdvice`.

### DTOs (Data Transfer Objects)
- **QuestionResponse**: Represents a question with options for the client.
- **SubmitAnswerRequest**: Input for submitting an answer.
- **SubmitAnswerResponse**: Output for answer submission results.
- **ErrorResponse**: Error details returned in case of exceptions.

---

## Prerequisites

Before running the application, ensure you have:
- **JDK 11** or higher
- **Maven** installed
- (Optional) API testing tools like **Postman**

---

## Installation and Running

### 1. Clone the Repository
```bash
git clone https://github.com/PrathamBakshi/Quiz-App.git
cd Quiz-App
```
### 2. Build the Project
```bash
mvn clean install
```
### 3. Run the Application
```bash
mvn spring-boot:run
```
The application will be available at:
- http://localhost:8080

### 4. Access the H2 Database
Visit:
- http://localhost:8080/h2-console

Use the following credentials:

- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: password
  ---
## API Endpoints
### User Dashboard
- GET /api/quiz/dashboard/{userId}
- Fetch user statistics.
### Take Quiz
- POST /api/quiz/take/{userId}
- Retrieve a random question.
### Submit Answer
- POST /api/quiz/submit/{userId}
- Submit an answer and get feedback.
- Request Body:
```json
{
  "questionId": 1,
  "answer": "A"
}
```
### End Quiz
- POST /api/quiz/end/{userId}
- Finalize quiz and view results.
  ---
## Database Configuration
- The application uses an in-memory H2 database. Preloaded sample data is included in src/main/resources/data.sql.

### Sample User
- User ID: 1
- Name: John Doe
### Sample Questions
- Example question:

- Question: What is Java?
  - A: A programming language
  - B: A type of coffee
  - C: An operating system
  - D: A web browser
  - Correct Answer: A
---

## Technologies Used
### Spring Boot
### Hibernate/JPA
### H2 Database
### Maven
### Java 11
### Lombok
---
## Postman Collection

You can use the Postman collection to test the API endpoints of the Quiz App.

### Access the Postman Collection

The Postman collection is hosted online and can be accessed via the following link:

[QuizApp Postman Collection](https://api.postman.com/collections/29138285-52781ab3-e68d-4749-ad5b-f866404d04ef?access_key=PMAT-01JE6PXCNYGH42PTBZ79C4GCVP)

---

### Steps to Use the Collection

1. Click the link above to view the collection on Postman.
2. If you have a Postman account, click **Fork Collection** to add it to your workspace.
3. If you don't have an account, download the collection by clicking on the **Export** option.
4. Open Postman, and import the collection by clicking **Import** in the top-left corner.
5. Test the Quiz App API endpoints directly from Postman.

---

### Endpoints Included in the Collection

1. **Get User Dashboard**
   - **Method**: `GET`
   - **URL**: `/api/quiz/dashboard/{userId}`
   - **Description**: Fetch the user statistics and quiz performance.

2. **Take Quiz**
   - **Method**: `POST`
   - **URL**: `/api/quiz/take/{userId}`
   - **Description**: Fetch a random question for the user.

3. **Submit Answer**
   - **Method**: `POST`
   - **URL**: `/api/quiz/submit/{userId}`
   - **Body**:
     ```json
     {
       "questionId": 1,
       "answer": "A"
     }
     ```
   - **Description**: Submit an answer for evaluation.

4. **End Quiz**
   - **Method**: `POST`
   - **URL**: `/api/quiz/end/{userId}`
   - **Description**: End the quiz and finalize the results.

---

### Example Request and Response

**Endpoint**: Submit Answer  
**Request Body**:
```json
{
  "questionId": 2,
  "answer": "B"
}
```
Response:

```json
Copy code
{
  "result": "Correct"
}
```
