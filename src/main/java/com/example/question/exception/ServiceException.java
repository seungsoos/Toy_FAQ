package com.example.question.exception;

public class ServiceException extends RuntimeException {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(ServiceErrorCode errorCode) {
        super(errorCode.getDesc());
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
