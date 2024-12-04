package com.example.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuizUser {
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private int totalQuestionsAttempted = 0;

    private int correctAnswers = 0;

    private double score = 0.0;
}
