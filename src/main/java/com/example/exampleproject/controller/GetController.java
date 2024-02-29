package com.example.exampleproject.controller;

import com.example.exampleproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value="/hello", method= RequestMethod.GET) //=> 고전적인 방법으로 method를 따로 지정해야 함
    public String getHello() {
        return "Hello World";
    }

    //@__Mapping을 통해 method 지정하여 매핑 가능
    //http://localhost:8080/api/v1/get-api/whoisboyfriend
    @GetMapping("/whoisboyfriend")
    public String getName() {
        return "최수빈♡최범규";
    }

    //{String 값} == var 일 때(default)
    //http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }

    //{String 값} != var 일 때
    //http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    //주소에서 파라미터를 받아 리턴
    //http://localhost:8080/api/v1/get-api/request1?name={name 값}&email={email 값}&organization={organization 값}
    @GetMapping("/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return "name = " + name + "\n" +
                "email = " + email + "\n" +
                "organization = " + organization;
    }

    //주소에서 파라미터를 Map으로 받아 리턴
    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        //StringBuilder : 변경 가능한 문자열 생성 => .append()를 통해 문자열을 합칠 수 있음
        StringBuilder sb = new StringBuilder();

        // param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
        param.entrySet().forEach(
                map -> {sb.append(map.getKey() + " : " + map.getValue() + "\n");
                });
        //StringBuilder 사용하면 혼자 출력될 수 없으므로 toString()를 붙여줌
        return sb.toString();
    }

    //주소 값에서 파라미터를 받아 MemberDTO 저장 후 리턴
    //http://localhost:8080/api/v1/get-api/request3?name={name 값}&email={email 값}&organization={organization 값}
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memerDTO) {
        //return  memerDTO.getName() + " " + memerDTO.getEmail() + " " + memerDTO.getOrganization();
        return memerDTO.toString();
    }


}
