package com.example.exampleproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {
    private String name;
    private String email;
    private String organization;
}
