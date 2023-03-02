package com.bo.member.dto;

import com.bo.member.entity.Member;
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
    private Long deptId;
    private String name;
    private String gender;
    private String role;

    public Member toEntity() {
        return Member.builder()
                .memberIdx(this.getMemberIdx())
                .username(this.getUsername())
                .password(this.getPassword())
                .deptIdx(this.getDeptId())
                .name(this.getName())
                .gender(this.getGender())
                .role(this.getRole())
                .build();
    }
}
