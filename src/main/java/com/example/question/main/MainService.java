package com.example.question.main;

import com.example.question.db.entity.QuestionEntity;
import com.example.question.db.mapper.QuestionMapper;
import com.example.question.exception.ServiceErrorCode;
import com.example.question.exception.ServiceException;
import com.example.question.main.request.QuestionCreateRequest;
import com.example.question.main.request.QuestionUpdateRequest;
import com.example.question.main.response.QuestionAdminResponse;
import com.example.question.main.response.QuestionServiceResponse;
import com.example.question.main.response.QuestionServiceSelectResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {

    private final QuestionMapper questionMapper;
    
    //관리자조회(노출여부, 삭제여부 상관없이 출력)
    @Transactional(readOnly = true)
    public List<QuestionAdminResponse> findByAllList(){
        List<QuestionEntity> list = questionMapper.findByAllList();
        return list.stream()
                .map(QuestionAdminResponse::new)
                .collect(Collectors.toList());
    }
    //사용자조회(노출설정 및 미삭제만 출력)
    @Transactional(readOnly = true)
    public List<QuestionServiceResponse> findByViewList(){

        List<QuestionEntity> list = questionMapper.findByViewList();
        return list.stream()
                .map(QuestionServiceResponse::new)
                .collect(Collectors.toList());
    }
    //읽기
    @Transactional
    public QuestionServiceSelectResponse read(int faq_id){

        log.info("> 해당 Q&A 읽기 요청 시작 [ENTITY] {}:", faq_id);
        QuestionEntity questionEntity =  questionMapper.findByFaq_id(faq_id);
        if (Objects.isNull(questionEntity)) {
            throw new ServiceException(ServiceErrorCode.INTERNAL_SERVER_ERROR);
        }
        log.info("> 해당 Q&A 읽기 요청 끝 [ENTITY] {}:", faq_id);
        return new QuestionServiceSelectResponse(questionEntity);
    }
    //등록
    @Transactional
    public void createQuestion(QuestionCreateRequest questionCreateRequest){

        log.info("> 자주하는질문등록 요청 시작 [ENTITY] {}:", questionCreateRequest);
        questionMapper.createQuestion(questionCreateRequest);
        log.info("> 자주하는질문등록 요청 종료 [ENTITY] {}:", questionCreateRequest);
    }

    //질문&답변 수정
    @Transactional
    public void updateQuestion(QuestionUpdateRequest questionUpdateRequest){

        log.info("> 자주하는질문수정 요청 시작 [ENTITY] {}:", questionUpdateRequest);
        questionMapper.updateQuestion(questionUpdateRequest);
        log.info("> 자주하는질문등록 요청 종료 [ENTITY] {}:", questionUpdateRequest);
    }
    //순서 수정
    @Transactional
    public void updateOrderQuestion(int faq_id, int view_order){

        if (Objects.isNull(faq_id)) {
            throw new ServiceException(ServiceErrorCode.SERVICE_ERROR_S0004);
        } else if (Objects.isNull(view_order)) {
            throw new ServiceException(ServiceErrorCode.SERVICE_ERROR_S0005);
        }

        log.info("> 순서수정 요청 시작 [ENTITY] {}:", view_order);
        questionMapper.updateOrderQuestion(faq_id, view_order);
        log.info("> 순서수정 요청 종료 [ENTITY] {}:", view_order);
    }
    //노출여부 수정
    @Transactional
    public void updateViewQuestion(int faq_id, String is_view){

        if (Objects.isNull(faq_id)) {
            throw new ServiceException(ServiceErrorCode.SERVICE_ERROR_S0004);
        } else if (Objects.isNull(is_view)) {
            throw new ServiceException(ServiceErrorCode.SERVICE_ERROR_S0006);
        }

        log.info("> 노출수정 요청 시작 [ENTITY] {}:", is_view);
        questionMapper.updateViewQuestion(faq_id, is_view);
        log.info("> 노출수정 요청 종료 [ENTITY] {}:", is_view);
    }
    //삭제
    @Transactional
    public void deleteQuestion(int faq_id){

        if (Objects.isNull(faq_id)) {
            throw new ServiceException(ServiceErrorCode.SERVICE_ERROR_S0004);
        }

        log.info("> 삭제 요청 시작 [ENTITY] {}:", faq_id);
        questionMapper.deleteQuestion(faq_id);
        log.info("> 삭제 요청 종료 [ENTITY] {}:", faq_id);
    }
}
