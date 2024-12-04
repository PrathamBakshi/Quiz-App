# Quiz-App
QuizApp is a RESTful web application that allows users to take quizzes, submit answers, and track their performance. The application is built using Spring Boot, H2 Database, and follows the MVC architecture.

Features
User Dashboard: View user statistics such as total questions attempted, correct answers, and score percentage.
Random Question Selection: Fetches a random question for users to answer.
Answer Submission: Validates user-submitted answers and updates their scores.
Exception Handling: Handles runtime exceptions gracefully with meaningful error messages.
In-Memory Database: Uses H2 for quick setup and testing.
Tech Stack
Backend: Spring Boot
Database: H2 (In-Memory)
ORM: Hibernate (JPA)
Build Tool: Maven
Language: Java
Testing: Built-in support for H2 Console
Project Structure
Models
QuizUser: Represents a quiz participant with attributes like name, score, and correctAnswers.
Question: Stores quiz questions with options (A, B, C, D) and the correct answer.
Repositories
UserRepository: For managing QuizUser entities.
QuestionRepository: For managing Question entities and fetching random questions.
Services
QuizService: Core business logic for user and quiz operations.
Controllers
QuizController:
/api/quiz/dashboard/{userId}: Fetch user dashboard.
/api/quiz/take/{userId}: Get a random question for the user.
/api/quiz/submit/{userId}: Submit an answer and update the user's score.
/api/quiz/end/{userId}: End the quiz and finalize the user's score.
DTOs
QuestionResponse: For returning question details to the user.
SubmitAnswerRequest: For submitting an answer.
SubmitAnswerResponse: For returning the result of an answer submission.
ErrorResponse: For structured error handling.
Database Schema
Tables
quiz_user: Stores user data.
question: Stores quiz questions.
Sample Data
The application initializes with sample questions and users. You can customize these in the data.sql file.

Getting Started
Prerequisites
Java 11
Maven
Steps to Run
Clone the repository:

bash
git clone https://github.com/PrathamBakshi/Quiz-App.git
cd Quiz-App
Build the project:

bash
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
Access the H2 console (optional):

URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: password
API Documentation (Example URLs):

Get User Dashboard: GET /api/quiz/dashboard/{userId}
Take Quiz: POST /api/quiz/take/{userId}
Submit Answer: POST /api/quiz/submit/{userId}
Error Handling
The application uses a global exception handler (ExceptionHandlerAdvice) to handle runtime exceptions and provide structured error messages.

Example Error Response
json
{
  "error": "QuizUser not found with ID: 1"
}
Sample SQL Data
The data.sql file preloads the database with:

10 Questions
5 Users
You can customize the data as needed.


