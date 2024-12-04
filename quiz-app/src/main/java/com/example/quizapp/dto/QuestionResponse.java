package com.example.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionResponse {
    private long id;
    private String question;
    private String A;
    private String B;
    private String C;
    private String D;
}
