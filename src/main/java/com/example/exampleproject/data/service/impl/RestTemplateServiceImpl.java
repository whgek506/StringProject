package com.example.exampleproject.data.service.impl;

import com.example.exampleproject.data.service.RestTemplateService;
import com.example.exampleproject.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String getAroundHub() {
        URI uri = UriComponentsBuilder //URI : 경로 요청
                .fromUriString("http://localhost:9090") //경로 지정
                .path("api/server/around-hub") //뒤에 붙는 경로
                .encode() // 기본적으로 UTF-8
                .build() // 값 넣기
                .toUri(); //uri 값 변경

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {} ", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/name")
                .queryParam("name", "jaejae") // == @RequestParam 동일하며 값을 넣는 방식 지정 -> queryParam("key", "value")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {} ", responseEntity.getStatusCode());
        LOGGER.info("body : {} ", responseEntity.getBody());
        return responseEntity.getBody();
    }

    @Override
    public String getName2() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/path-variable/{name}")
                .encode()
                .build()
                .expand("jaejae") //{name}의 값을 넣어줌 (복수의 값을 넣어야할 경우 , 를 추가하여 구분)
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {} ", responseEntity.getStatusCode());
        LOGGER.info("body : {} ", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public ResponseEntity<MemberDTO> postDto() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/member")
                .queryParam("name", "jaejae")
                .queryParam("email", "jjj@jjj.com")
                .queryParam("organization", "SM")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO(); //RequestBody에 값을 넣기 위해 사용
        memberDTO.setName("jaejae!!");
        memberDTO.setEmail("aaa@aaa.com");
        memberDTO.setOrganization("SM!!");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);

        LOGGER.info("status code : {} ", responseEntity.getStatusCode());
        LOGGER.info("body : {} ", responseEntity.getBody());

        return responseEntity;
    }

    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/add-header")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("jaejae");
        memberDTO.setEmail("jjj@jjj.com");
        memberDTO.setOrganization("SM");

        RequestEntity<MemberDTO> requestEntity = RequestEntity
                .post(uri) //method 타입
                .header("around-header", "Around Hub Studio") //header("key", "value")
                .body(memberDTO);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity, MemberDTO.class); // exchange(값, 타입)

        LOGGER.info("status code : {} ", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }
}
