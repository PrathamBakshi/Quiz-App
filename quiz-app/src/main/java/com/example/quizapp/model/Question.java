package com.example.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @Column(name = "ques_id")
    private long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String A;

    @Column(nullable = false)
    private String B;

    @Column(nullable = false)
    private String C;

    @Column(nullable = false)
    private String D;

    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;
}
