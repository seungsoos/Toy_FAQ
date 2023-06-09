package com.example.question.faq.response;

import com.example.question.db.entity.QuestionEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
public class QuestionServiceResponse {
    private int faq_id;                 //자주하는 질문 아이디
    private String question;            //질문
    private String answer;              //답변
    private int view_order;             //노출 순서

    public QuestionServiceResponse(QuestionEntity entity) {
        this.faq_id = entity.getFaq_id();
        this.question = entity.getQuestion();
        this.answer = entity.getAnswer();
        this.view_order = entity.getView_order();
    }
}
