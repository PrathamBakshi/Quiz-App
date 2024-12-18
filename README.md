# Quiz App

The **Quiz App** is a Spring Boot-based RESTful application designed to manage quizzes. It allows users to attempt questions, track their scores, and view their performance.

## Features

- **User Dashboard**: View quiz statistics such as total questions attempted, correct answers, and score percentage.
- **Take Quiz**: Fetch random questions from the database.
- **Submit Answer**: Validate answers and update user statistics.
- **End Quiz**: Finalize quiz and display user results.
- **Exception Handling**: Graceful error handling with appropriate messages.

---

## Technologies Used
- Spring Boot
- Hibernate/JPA
- H2 Database
- Maven
- Java 11
- Lombok

---

## Project Structure

### Models
- **QuizUser**: Represents a quiz user with attributes like name, total questions attempted, correct answers, and score.
- **Question**: Stores quiz questions with options (a, b, c, d) and the correct answer.

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
## Running the Application in IntelliJ IDEA

### 1. **Clone the Repository**
   - Open IntelliJ IDEA.
   - Go to **File** > **New** > **Project from Version Control**.
   - Enter the URL of the repository: `https://github.com/PrathamBakshi/Quiz-App.git` and click **Clone**.

### 2. **Open the Project**
   - After cloning, IntelliJ will automatically open the project.

### 3. **Build the Project**
   - Once the project is opened, IntelliJ will automatically detect the `pom.xml` file. If not, right-click the `pom.xml` file in the **Project** view and select **Add as Maven Project**.
   - You can build the project by navigating to **Build** > **Build Project** or by clicking the **Build** button on the top toolbar.

### 4. **Run the Application**
   - Locate the **QuizAppApplication** class in the `src/main/java/com/example/quizapp` directory.
   - Right-click the `QuizAppApplication.java` file and select **Run 'QuizAppApplication'**.

### 5. **Verify the Application**
   - After running the application, you should see logs in the **Run** window showing that the Spring Boot application is starting up.
   - The application should be available locally, typically at `http://localhost:8080`.
     
### 6. Access the H2 Database
Visit:
- http://localhost:8080/h2-console

Use the following credentials:

- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: password
  
### 7. **Stop the Application**
   - To stop the application, click the red **Stop** button in the **Run** window.
  ---
## Postman Collection

You can use the Postman collection to test the API endpoints of the Quiz App.

### Access the Postman Collection

The Postman collection is hosted online and can be accessed via the following link:

[QuizApp Postman Collection](https://api.postman.com/collections/29138285-52781ab3-e68d-4749-ad5b-f866404d04ef?access_key=PMAT-01JE6PXCNYGH42PTBZ79C4GCVP)

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
{
  "result": "Correct"
}
```
---
### Screenshots

![postman_take_api](https://github.com/user-attachments/assets/7e937dd7-137c-4933-a27f-f9659a142da9)
![postman_submit_api](https://github.com/user-attachments/assets/2d4b7406-9561-489d-af6f-1cbe46d10d31)
![postman_dashboard_api](https://github.com/user-attachments/assets/6b39e564-3402-4423-b327-2fbf16a0e428)
![postman_end_api](https://github.com/user-attachments/assets/2a00c0e5-597d-4a2b-89b3-1e8c1f26aaf7)

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

