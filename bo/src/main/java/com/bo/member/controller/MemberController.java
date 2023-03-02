package com.bo.member.controller;

import com.bo.bible.service.BibleService;
import com.bo.member.dto.JoinDto;
import com.bo.member.dto.MemberDto;
import com.bo.member.entity.MemberContext;
import com.bo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final BibleService bibleService;

    @PostMapping("")
    public ResponseEntity<Void> createMember(@RequestBody JoinDto joinDto) {
        MemberDto memberDto = memberService.create(joinDto);

//        bibleService.addBiblesAtMember(memberDto.getMemberIdx());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody MemberDto loginDto) {
        MemberDto memberDto = memberService.login(loginDto.getUsername(), loginDto.getPassword());

        String accessToken = memberService.genAccessToken(memberDto.toEntity());


        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("memName", memberDto.getName());

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> me(@AuthenticationPrincipal MemberContext memberContext) {
        if (memberContext == null) { // 임시코드, 나중에는 시프링 시큐리티를 이용해서 로그인을 안했다면, 아예 여기로 못 들어오도록

        }
        return new ResponseEntity<>(Map.of("member", memberContext == null ? "unknown" : memberContext), HttpStatus.OK);
    }
}
