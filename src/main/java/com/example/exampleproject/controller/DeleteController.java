package com.example.exampleproject.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api")
public class DeleteController {

    //http://localhost:8080/api/v1/get-api/delete/{String 값}
    @DeleteMapping(value = "/delete/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        //DB에서 variable 값을 조회 후 삭제 실행 -> 실행 결과에 대한 status 값을 리턴하는 것이 일반적
        //variable는 특정할 수 있는 값으로 지정(ex) Id)
        return variable;
    }
}
