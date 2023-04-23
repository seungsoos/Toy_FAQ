package com.example.question.service;

import com.example.question.exception.ServiceException;
import com.example.question.faq.MainService;
import com.example.question.faq.request.QuestionCreateRequest;
import com.example.question.faq.request.QuestionUpdateRequest;
import com.example.question.faq.response.QuestionAdminResponse;
import com.example.question.faq.response.QuestionServiceResponse;
import com.example.question.faq.response.QuestionServiceSelectResponse;
import com.example.question.faq.response.QuestionUpdateResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Transactional
@SpringBootTest
public class MainServiceTest {


    @Autowired
    private MainService mainService;
    private int faq_id;
    private String question;
    private String answer;
    private String is_view;
    private int view_order;
    private int adminSize;              //관리자 조회
    private int adminDeleteSize;        //관리자 삭제조회
    private int usersSize;              // 회원 조회

    @BeforeEach
    void setUp(){
        faq_id = 4;
        question = "제목1";
        answer = "답변1";
        is_view = "Y";
        //---------------------------- 등록 ----------------------------
        QuestionCreateRequest questionCreateRequest = new QuestionCreateRequest(question, answer, is_view);
        mainService.createQuestion(questionCreateRequest);
        //---------------------------- 등록 ----------------------------
        //---------------------------- 질문&답변 수정 ----------------------------
        question = "제목2";
        answer = "답변2";
        //---------------------------- 질문&답변 수정 ----------------------------
        //---------------------------- 순서 수정 ----------------------------
        view_order = 1;
        //---------------------------- 순서 수정 ----------------------------
        //---------------------------- 노출여부 수정 ----------------------------
        is_view = "N";
        //---------------------------- 노출여부 수정 ----------------------------
        
        adminSize = mainService.findByAllList().size();
        adminDeleteSize = mainService.findByDeleteList().size();
        usersSize = mainService.findByViewList().size();
    }

    /*@Test
    @DisplayName("등록_정상")
    void createQuestion_ok() {
        QuestionCreateRequest questionCreateRequest = new QuestionCreateRequest(question, answer, is_view);
        QuestionCreateResponse questionCreateResponse = mainService.createQuestion(questionCreateRequest);
        assertThat(questionCreateResponse).usingRecursiveComparison().isEqualTo(questionCreateResponse);

    }*/

    @Test
    @DisplayName("등록_비정상")
    void createQuestion_fail() {
        QuestionCreateRequest questionCreateRequest = new QuestionCreateRequest(null, answer, is_view);
        assertThrows(DataIntegrityViolationException.class, () ->
                mainService.createQuestion(questionCreateRequest));
    }
    @Test
    @DisplayName("관리자 조회")
    void findByAllList() {
        List<QuestionAdminResponse> list = mainService.findByAllList();
        assertThat(list.size()).isEqualTo(adminSize);
    }
    @Test
    @DisplayName("관리자 조회(삭제만)")
    void findByDeleteList(){
        List<QuestionAdminResponse> list = mainService.findByDeleteList();
        assertThat(list.size()).isEqualTo(adminDeleteSize);
    }
    @Test
    @DisplayName("사용자 조회")
    void userReadList(){
        List<QuestionServiceResponse> list = mainService.findByViewList();
        assertThat(list.size()).isEqualTo(usersSize);
    }
    @Test
    @DisplayName("읽기_정상")
    void read_ok(){
        QuestionServiceSelectResponse selectResponse = mainService.read(faq_id);
        assertThat(selectResponse.getFaq_id()).isSameAs(faq_id);
    }
    @Test
    @DisplayName("읽기_비정상")
    void read_fail(){
        faq_id = 0;
        assertThrows(ServiceException.class, () -> mainService.read(faq_id));
    }
    @Test
    @DisplayName("질문&답변 수정_정상")
    void updateQuestion_ok(){
        QuestionUpdateRequest questionUpdateRequest = new QuestionUpdateRequest();
        questionUpdateRequest.setFaq_id(faq_id);
        questionUpdateRequest.setQuestion(question);
        questionUpdateRequest.setAnswer(answer);

        QuestionUpdateResponse questionUpdateResponse = mainService.updateQuestion(questionUpdateRequest);


        assertThat(questionUpdateRequest).usingRecursiveComparison().isEqualTo(questionUpdateResponse);
    }
    @Test
    @DisplayName("질문&답변 수정_비정상")
    void updateQuestion_fail(){
        QuestionUpdateRequest questionUpdateRequest = new QuestionUpdateRequest();
        questionUpdateRequest.setFaq_id(faq_id);
        questionUpdateRequest.setQuestion(question);
        questionUpdateRequest.setAnswer(answer);

        assertThrows(ServiceException.class, () -> mainService.updateQuestion(questionUpdateRequest));
    }
    @Test
    @DisplayName("순서 수정_정상")
    void updateOrderQuestion_ok(){
        mainService.updateOrderQuestion(faq_id, view_order);
    }
    @Test
    @DisplayName("순서 수정_비정상")
    void updateOrderQuestion_fail(){
        assertThrows(ServiceException.class, () -> mainService.updateOrderQuestion(faq_id, view_order));
    }
    @Test
    @DisplayName("노출여부 수정_정상")
    void updateViewQuestion_ok(){
        mainService.updateViewQuestion(faq_id, is_view);
    }
    @Test
    @DisplayName("노출여부 수정_비정상")
    void updateViewQuestion_fail(){
        assertThrows(ServiceException.class, () -> mainService.updateViewQuestion(faq_id, is_view));
    }


}
