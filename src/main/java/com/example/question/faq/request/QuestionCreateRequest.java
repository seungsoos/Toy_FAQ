package com.example.question.faq.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor

@AllArgsConstructor
public class QuestionCreateRequest {

    @NotNull(message = "제목은 필수 입력사항입니다.")
    private String question;
    @NotNull(message = "답변은 필수 입력사항입니다.")
    private String answer;
    @NotNull(message = "노출여부는 필수 입력사항입니다.")
    private String is_view;



}
