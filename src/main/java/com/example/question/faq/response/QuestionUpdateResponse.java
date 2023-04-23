package com.example.question.faq.response;

import com.example.question.faq.request.QuestionCreateRequest;
import com.example.question.faq.request.QuestionUpdateRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class QuestionUpdateResponse {

    private int faq_id;
    private String question;
    private String answer;
    private int view_order;             //노출 순서

    public QuestionUpdateResponse(QuestionUpdateRequest questionUpdateRequest) {
        this.question = questionUpdateRequest.getQuestion();
        this.answer = questionUpdateRequest.getAnswer();
        this.faq_id = questionUpdateRequest.getFaq_id();
        this.view_order = questionUpdateRequest.getView_order();
    }
}
