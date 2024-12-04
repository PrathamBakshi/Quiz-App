
CREATE TABLE IF NOT EXISTS question (
    ques_id BIGINT  PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    A VARCHAR(255) NOT NULL,
    B VARCHAR(255) NOT NULL,
    C VARCHAR(255) NOT NULL,
    D VARCHAR(255) NOT NULL,
    correct_answer VARCHAR(1) NOT NULL
);

CREATE TABLE IF NOT EXISTS quiz_user (
    user_id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    total_questions_attempted INT DEFAULT 0,
    correct_answers INT DEFAULT 0,
    score DOUBLE DEFAULT 0.0
);

-- Insert sample data
INSERT INTO question (ques_id, question, A, B, C, D, correct_answer)
VALUES (1,'What is Java?', 'A programming language', 'A type of coffee', 'An operating system', 'A web browser', 'A');

INSERT INTO question (ques_id, question, A, B, C, D, correct_answer)
VALUES
(2, 'What is the capital of France?', 'Paris', 'Rome', 'Berlin', 'Madrid', 'A'),
(3, 'Which planet is known as the Red Planet?', 'Earth', 'Mars', 'Jupiter', 'Venus', 'B'),
(4, 'What is the chemical symbol for water?', 'H2O', 'O2', 'CO2', 'N2', 'A'),
(5, 'Who wrote "Romeo and Juliet"?', 'William Shakespeare', 'Mark Twain', 'Charles Dickens', 'Jane Austen', 'A'),
(6, 'What is the largest mammal on Earth?', 'Elephant', 'Blue Whale', 'Giraffe', 'Shark', 'B'),
(7, 'Which element has the atomic number 1?', 'Oxygen', 'Hydrogen', 'Carbon', 'Nitrogen', 'B'),
(8, 'What is the square root of 64?', '6', '7', '8', '9', 'C'),
(9, 'Which language is primarily used for Android development?', 'Java', 'Python', 'Ruby', 'C#', 'A'),
(10, 'Who painted the Mona Lisa?', 'Leonardo da Vinci', 'Vincent van Gogh', 'Pablo Picasso', 'Claude Monet', 'A'),
(11, 'What is the process by which plants make their food?', 'Respiration', 'Photosynthesis', 'Digestion', 'Transpiration', 'B');


INSERT INTO quiz_user (user_id, name, total_questions_attempted, correct_answers, score)
VALUES
(1,'John Doe', 0, 0, 0),
(2,'Jane Smith', 15, 10, 66.67),
(3,'Alice Brown', 5, 3, 60.0),
(4,'Bob White', 20, 15, 75.0),
(5,'Charlie Black', 12, 9, 75.0);
