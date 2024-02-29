package com.example.exampleproject.controller;

import com.example.exampleproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    //http://localhost:8080/api/v1/post-api/default
    @PostMapping(value = "/default")
    public String postMethod() {
        return "안녕하세요!";
    }
    //http://localhost:8080/api/v1/post-api/member1
    @PostMapping(value = "/member1")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        //
        postData.entrySet().forEach( map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }
    //http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMemberDTO(@RequestBody MemberDTO memberDTO) {
        //return  memerDTO.getName() + " " + memerDTO.getEmail() + " " + memerDTO.getOrganization();
        return memberDTO.toString();
    }
}
