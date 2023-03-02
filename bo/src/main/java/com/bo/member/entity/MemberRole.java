package com.bo.member.entity;

import lombok.Getter;

@Getter
public enum MemberRole {
    ADMIN("ADMIN"),
    SUBADMIN("SUBADMIN"),
    USER("MEMBER");

    MemberRole(String value) {
        this.value = value;
    }
    private String value;
}
