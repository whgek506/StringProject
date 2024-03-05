package com.example.exampleproject.common;

import org.springframework.http.HttpStatus;

public class AroundHubException extends Exception{

    private static final long serialVersionUID = 4663380430591151694L; //직렬화를 위해 serialVersionUID 생성
    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public AroundHubException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(exceptionClass.toString() + message); //메세지 정의(부모인 Exception로 부터 상속 받아서 super() 메소드 활용)
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass() { //에러가 생기면 정의 한 값 리턴
        return exceptionClass;
    }
    public int getHttpStatusCode() {
        return httpStatus.value(); //시리얼 넘버 값 리턴
    }
    public String getHttpStatusType() {
        return httpStatus.getReasonPhrase();
    }
    public HttpStatus getHttpStatus() { //객체 자체를 리턴
        return httpStatus;
    }
}

