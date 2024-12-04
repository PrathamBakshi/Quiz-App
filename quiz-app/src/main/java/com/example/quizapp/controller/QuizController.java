package com.example.quizapp.controller;

import com.example.quizapp.dto.QuestionResponse;
import com.example.quizapp.dto.SubmitAnswerRequest;
import com.example.quizapp.dto.SubmitAnswerResponse;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizUser;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/dashboard/{userId}")
    public ResponseEntity<QuizUser> getUserDashboard(@PathVariable Long userId) {
        QuizUser quizUser = quizService.getUser(userId);
        return ResponseEntity.ok(quizUser);
    }

    @PostMapping("/take/{userId}")
    public ResponseEntity<QuestionResponse> takeQuiz(@PathVariable Long userId) {
        Question question = quizService.getRandomQuestion(userId);
        QuestionResponse questionResponse = new QuestionResponse(
                question.getId(),
                question.getQuestion(),
                question.getA(),
                question.getB(),
                question.getC(),
                question.getD()
        );
        return ResponseEntity.ok(questionResponse);
    }

    @PostMapping("/submit/{userId}")
    public ResponseEntity<SubmitAnswerResponse> submitAnswer(@PathVariable Long userId, @RequestBody SubmitAnswerRequest request) {
        String result = quizService.submitAnswer(userId, request.getQuestionId(), request.getAnswer());
        SubmitAnswerResponse submitAnswerResponse = new SubmitAnswerResponse(result);
        return ResponseEntity.ok(submitAnswerResponse);
    }

    @PostMapping("/end/{userId}")
    public ResponseEntity<QuizUser> endQuiz(@PathVariable Long userId) {
        quizService.endQuiz(userId);
        QuizUser quizUser = quizService.getUser(userId);
        return ResponseEntity.ok(quizUser);
    }
}
