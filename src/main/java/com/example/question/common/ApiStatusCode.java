package com.example.question.common;

public interface ApiStatusCode {
    /**
     * 공통
     */
    String OK = "200";
    String BAD_REQUEST = "400";
    String UNAUTHORIZED = "401";
    String FORBIDDEN = "403";
    String NOT_FOUND = "404";
    String SERVER_ERROR = "500";
    String SERVICE_UNAVAILABLE = "503";

    String SEND_SMS_FAILURE = "1003";
    String INVALID_AUTHORIZED_CODE = "1004";
    String EXCEEDED_CODE = "1005";
    String TEXT_AUTHORIZED_EXPIRED = "1006";
    String NOT_EXIST_REQUEST_NUMBER = "1007";
    String NOT_EXIST_SUBSCRIBER = "1014";

    /**
     * 관리자페이지
     */
    String UNAUTHORIZED_ACCOUNT = "2000";
    String INVALID_ID = "2001";
    String INVALID_PWD = "2002";
    String DUPLICATE_ID = "2003";
    String NOT_MATCH_EMAIL = "2004";
    String INVALID_INTERVAL = "2005";
    String NOT_MATCH_CTN = "2006";
    String SUSPENDED_ACCOUNT = "2007";
    String POPUP_IMAGE_USED = "2008";
    String UNAUTHORIZED_REGIST_ADMIN = "2009";
    String UNAUTHORIZED_DELETE_ADMIN = "2010";
    String CHANGE_PWD = "2011";
    String DUPLICATE_OLD_PWD = "2012";
    String NOT_USAGE_TIME = "2013";
    String TABOOLA_ERROR = "51001005";
}
