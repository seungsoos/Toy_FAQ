package com.example.question.db.entity;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionEntity {

    private int faq_id;                 //자주하는 질문 아이디
    private String question;            //질문
    private String answer;              //답변
    private LocalDateTime created_at;   //작성 일자
    private LocalDateTime updated_at;   //수정 일자
    private LocalDateTime deleted_at;   //삭제 일자
    private String is_view;             //노출 여부
    private int view_order;             //노출 순서
}
