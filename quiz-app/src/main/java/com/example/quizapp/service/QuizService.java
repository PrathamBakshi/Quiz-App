package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizUser;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuizService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public QuizUser getUser(Long userId) {
        return userRepository.findUserById(userId).orElseThrow(() ->
                new RuntimeException("QuizUser not found with ID: " + userId));
    }

    public Question getRandomQuestion(Long userId) {
        return questionRepository.findRandomQuestion().orElse(null);
    }

    public String submitAnswer(Long userId, Long questionId, String answer) {
        QuizUser quizUser = userRepository.findUserById(userId).orElseThrow(() ->
                new RuntimeException("QuizUser not found with ID: " + userId));

        Question question = questionRepository.findById(questionId).orElseThrow(() ->
                new RuntimeException("Question not found with ID: " + questionId));
        if (!Set.of("a", "b", "c", "d").contains(answer.toLowerCase())) {
            throw new RuntimeException("Option '" + answer + "' not found. Please select from the given options (a, b, c, d).");
        }

        boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(answer);
        if (isCorrect) {
            quizUser.setCorrectAnswers(quizUser.getCorrectAnswers() + 1);
        }
        quizUser.setTotalQuestionsAttempted(quizUser.getTotalQuestionsAttempted() + 1);
        quizUser.setScore((double) quizUser.getCorrectAnswers() / quizUser.getTotalQuestionsAttempted() * 100);
        userRepository.save(quizUser);
        return isCorrect ? "Correct" : "Incorrect";
    }


    public void endQuiz(Long userId) {
        QuizUser quizUser = userRepository.findUserById(userId).orElseThrow(() ->
                new RuntimeException("QuizUser not found with ID: " + userId));
        userRepository.save(quizUser);
    }
}
