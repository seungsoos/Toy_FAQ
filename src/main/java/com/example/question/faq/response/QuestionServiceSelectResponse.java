package com.example.question.faq.response;

import com.example.question.db.entity.QuestionEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
public class QuestionServiceSelectResponse {

    private int faq_id;                 //자주하는 질문 아이디
    private String question;            //질문
    private String answer;              //답변
    private LocalDateTime created_at;   //작성 일자
    private LocalDateTime updated_at;   //수정 일자

    public QuestionServiceSelectResponse(QuestionEntity questionEntity) {
        this.faq_id = questionEntity.getFaq_id();
        this.question = questionEntity.getQuestion();
        this.answer = questionEntity.getAnswer();
        this.created_at = questionEntity.getCreated_at();
        this.updated_at = questionEntity.getUpdated_at();
    }
}
