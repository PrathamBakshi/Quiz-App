package com.example.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubmitAnswerRequest {
    private Long questionId;
    private String answer;
}
