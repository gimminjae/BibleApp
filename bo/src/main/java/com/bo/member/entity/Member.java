package com.bo.member.entity;

import com.bo.member.dto.JoinDto;
import com.bo.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

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
    private Long deptIdx;
    private String deptName;
    private String name;
    private String gender;
    private String role;

    public MemberDto toDto() {
        return MemberDto.builder()
                .memberIdx(this.getMemberIdx())
                .username(this.getUsername())
                .password(this.getPassword())
                .deptId(this.getDeptIdx())
                .name(this.getName())
                .gender(this.getGender())
                .role(this.getRole())
                .deptName(this.getDeptName())
                .build();
    }
    public static Member from(JoinDto joinDto) {
        return Member.builder()
                .username(joinDto.getUsername())
                .deptIdx(null)
                .name(joinDto.getName())
                .gender(joinDto.getGender())
                .deptName(joinDto.getDeptName())
                .role(joinDto.getUsername().equals("ADMIN") ? "ADMIN" : "MEMBER")
                .build();
    }
    public Map<String, Object> getAccessTokenClaims() {
        Map<String, Object> map = new HashMap<>();
        map.put("memberIdx", getMemberIdx());
        map.put("username", getUsername());
        map.put("name", getName());

        return map;
    }
    // 현재 회원이 가지고 있는 권한들을 List<GrantedAuthority> 형태로 리턴
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(this.getRole().equals("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        } else if(this.getRole().equals("SUBADMIN")) {
            authorities.add(new SimpleGrantedAuthority("SUBADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("MEMBER"));
        }

        return authorities;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void modifyMemInfo(MemberDto memberDto) {
        this.setDeptIdx(memberDto.getDeptId());
        this.setDeptName(memberDto.getDeptName());
        this.setName(memberDto.getName());
        this.setGender(memberDto.getGender());
    }

    public void setDeptIdx(Long deptIdx) {
        this.deptIdx = deptIdx;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
