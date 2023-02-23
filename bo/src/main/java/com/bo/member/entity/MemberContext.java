package com.bo.member.entity;


import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@JsonIncludeProperties({"memberIdx", "username", "name", "role"})
public class MemberContext extends User {
    private final Long memberIdx;
    private final String username;
    private final String name;
//    private final String role;
    private Map<String, Object> attributes;

    private String userNameAttributeName;

    public MemberContext(Member member, List<GrantedAuthority> authorities) {
        super(member.getUsername(), member.getPassword(), authorities);
        this.memberIdx = member.getMemberIdx();
        this.name = member.getName();
        this.username = member.getUsername();
    }
    public MemberContext(Member member, List<GrantedAuthority> authorities, Map<String, Object> attributes, String userNameAttributeName) {
        this(member, authorities);
        this.attributes = attributes;
        this.userNameAttributeName = userNameAttributeName;
    }
    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return super.getAuthorities().stream().collect(Collectors.toSet());
    }
    public MemberContext(Member member) {
        super(member.getUsername(), member.getPassword(), member.getAuthorities());

        memberIdx = member.getMemberIdx();
        name = member.getName();
        username = member.getUsername();
    }
}
