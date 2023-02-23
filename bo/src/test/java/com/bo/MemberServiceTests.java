package com.bo;

import com.bo.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("회원 생성")
    void t1() {

    }
}
