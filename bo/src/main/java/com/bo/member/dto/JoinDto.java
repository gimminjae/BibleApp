package com.bo.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JoinDto {
    private String username;
    private String password1;
    private String password2;
    private String name;
    private String gender;
    private String deptName;
}
