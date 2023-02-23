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
    private Long deptId;
    private String name;
    private String gender;
    private String role;

    public MemberDto toDto() {
        return MemberDto.builder()
                .memberIdx(this.getMemberIdx())
                .username(this.getUsername())
                .password(this.getPassword())
                .deptId(this.getDeptId())
                .name(this.getName())
                .gender(this.getGender())
                .role(this.getRole())
                .build();
    }
    public static Member from(JoinDto joinDto) {
        return Member.builder()
                .username(joinDto.getUsername())
                .deptId(null)
                .name(joinDto.getName())
                .gender(joinDto.getGender())
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
        } else {
            authorities.add(new SimpleGrantedAuthority("MEMBER"));
        }

        return authorities;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
