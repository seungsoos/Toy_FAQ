package com.example.question.faq.response;

import com.example.question.db.entity.QuestionEntity;
import com.example.question.faq.request.QuestionCreateRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
public class QuestionCreateResponse {

    private String question;
    private String answer;
    private String is_view;

    public QuestionCreateResponse(QuestionCreateRequest questionCreateRequest) {
        this.question = questionCreateRequest.getQuestion();
        this.answer = questionCreateRequest.getAnswer();
        this.is_view = questionCreateRequest.getIs_view();
    }

}
