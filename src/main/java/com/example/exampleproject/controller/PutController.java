package com.example.exampleproject.controller;

import com.example.exampleproject.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    //http://localhost:8080/api/v1/put-api/default
    @PutMapping(value = "/default")
    public String putMethod() {
        return "안녕하세요!";
    }

    //http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        //
        postData.entrySet().forEach( map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    //http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDTO) {
        //return  memerDTO.getName() + " " + memerDTO.getEmail() + " " + memerDTO.getOrganization();
        return memberDTO.toString(); //Response Body에 toString 형태로 출력
    }

    //http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO) {
        return memberDTO; // //Response Body에 JSON 형태로 출력
    }

    //http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO) {
        //성공/실패 여부를 HttpStatus.ACCEPTED로 설정 후 Response body에 memberDTO를 JSON 형태로 리턴(==return memberDTO)
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO); //성공 시 Response Code에 ACCEPTED의 설정한 코드 값인 202가 출력
    }
}
