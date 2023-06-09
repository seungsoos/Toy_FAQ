package com.example.question.faq;

import com.example.question.common.ApiStatusCode;
import com.example.question.common.RootResponse;
import com.example.question.faq.request.QuestionCreateRequest;
import com.example.question.faq.request.QuestionUpdateRequest;
import com.example.question.faq.response.QuestionAdminResponse;
import com.example.question.faq.response.QuestionCreateResponse;
import com.example.question.faq.response.QuestionServiceResponse;
import com.example.question.faq.response.QuestionServiceSelectResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    //관리자 조회(노출여부 상관없이 출력)
    @GetMapping("/admin")
    public List<QuestionAdminResponse> adminList(
    ){
        List<QuestionAdminResponse> list = mainService.findByAllList();
        return list;
    }
    //관리자 조회(삭제처리만 출력)
    @GetMapping("/admin/delete")
    public List<QuestionAdminResponse> adminDeleteList(
    ){
        List<QuestionAdminResponse> list = mainService.findByDeleteList();
        return list;
    }
    //사용자 조회(노출설정 및 미삭제만 출력)
    @GetMapping("/users")
    public List<QuestionServiceResponse> userReadList(
    ){
        List<QuestionServiceResponse> list = mainService.findByViewList();
        return list;
    }
    //읽기
    @GetMapping("/faqs/{faq_id}")
    public QuestionServiceSelectResponse read(
            @PathVariable(value = "faq_id") int faq_id
    ){
        QuestionServiceSelectResponse selectResponse = mainService.read(faq_id);
        return selectResponse;
    }
    // 등록
    @PostMapping("/insert")
    public RootResponse<QuestionCreateResponse> create(
            @RequestBody
            @Valid QuestionCreateRequest questionCreateRequest
    ) {
        QuestionCreateResponse question = mainService.createQuestion(questionCreateRequest);
        return new RootResponse<>(ApiStatusCode.OK, "OK", question);
    }
    // 질문&답변 수정
    @PatchMapping("/update/fag")
    public RootResponse<Object> update(
            @RequestBody
            @Valid QuestionUpdateRequest questionUpdateRequest
    ) {
        mainService.updateQuestion(questionUpdateRequest);
        return new RootResponse<>(ApiStatusCode.OK, "OK", null);
    }
    // 순서 수정
    @PatchMapping("/update/order/{faq_id}/{view_order}")
    public RootResponse<Object> updateOrder(
            @PathVariable("faq_id") int faq_id,
            @PathVariable("view_order") int view_order
    ) {
        mainService.updateOrderQuestion(faq_id, view_order);
        return new RootResponse<>(ApiStatusCode.OK, "OK", null);
    }
    // 노출여부 수정
    @PatchMapping("/update/view/{faq_id}/{is_view}")
    public RootResponse<Object> updateView(
            @PathVariable("faq_id") int faq_id,
            @PathVariable("is_view") String is_view
    ) {
        mainService.updateViewQuestion(faq_id, is_view);
        return new RootResponse<>(ApiStatusCode.OK, "OK", null);
    }
    // 삭제
    @DeleteMapping("/question/{faq_id}")
    public RootResponse<Object> delete(
            @PathVariable("faq_id") int faq_id){
        mainService.deleteQuestion(faq_id);
        return new RootResponse<>(ApiStatusCode.OK,"OK",null);
    }

}
