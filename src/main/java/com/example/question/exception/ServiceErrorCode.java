package com.example.question.exception;

public enum ServiceErrorCode {

    INTERNAL_SERVER_ERROR("S_500", "서버 내부 오류입니다"),
    SERVICE_ERROR_S0001("S0001", "질문이 존재하지 않습니다"),
    SERVICE_ERROR_S0002("S0002", "답변이 존재하지 않습니다."),
    SERVICE_ERROR_S0003("S0003", "노출여부가 존재하지 않습니다."),
    SERVICE_ERROR_S0004("S0004", "질문 아이디가 존재하지 않습니다."),
    SERVICE_ERROR_S0005("S0005", "노출 순서가 존재하지 않습니다."),
    SERVICE_ERROR_S0006("S0006", "노출 여부가 존재하지 않습니다.")

    ;

    private String code;
    private String desc;

    ServiceErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
