package com.example.question.db.mapper;

import com.example.question.db.entity.QuestionEntity;
import com.example.question.faq.request.QuestionCreateRequest;
import com.example.question.faq.request.QuestionUpdateRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    //관리자 조회(노출여부 상관없이 출력)
    List<QuestionEntity> findByAllList();
    //관리자 조회(삭제처리만 출력)
    List<QuestionEntity> findByDeleteList();
    //사용자조회(노출설정 및 미삭제만 출력)
    List<QuestionEntity> findByViewList();
    //읽기
    QuestionEntity findByFaq_id(int faq_id);
    //등록
    void createQuestion(QuestionCreateRequest questionCreateRequest);
    //질문&답변 수정
    void updateQuestion(QuestionUpdateRequest questionUpdateRequest);
    //순서 수정
    void updateOrderQuestion(@Param("faq_id") int faq_id, @Param("view_order") int view_order);
    //노출여부 수정
    void updateViewQuestion(@Param("faq_id") int faq_id, @Param("is_view") String is_view);
    //삭제
    void deleteQuestion(int faq_id);


}
