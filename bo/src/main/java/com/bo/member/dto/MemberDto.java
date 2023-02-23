package com.bo.member.dto;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private Long memberIdx;
    private String username;
    private String password;
    private long deptId;
    private String name;
    private String gender;
}
