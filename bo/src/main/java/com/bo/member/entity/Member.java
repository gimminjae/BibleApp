package com.bo.member.entity;

import com.bo.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberIdx;
    @Column(unique = true)
    private String username;
    private String password;
    private long deptId;
    private String name;
    private String gender;

    public MemberDto toDto() {
        return MemberDto.builder()
                .memberIdx(this.getMemberIdx())
                .username(this.getUsername())
                .password(this.getPassword())
                .deptId(this.getDeptId())
                .name(this.getName())
                .gender(this.getGender())
                .build();
    }
}
