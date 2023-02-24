package com.bo.bible.controller;

import com.bo.bible.entity.Bible;
import com.bo.bible.service.BibleService;
import com.bo.member.entity.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bible")
public class BibleController {
    private final BibleService bibleService;

    @GetMapping("")
    public ResponseEntity<List<Bible>> getBibleListByMember(@AuthenticationPrincipal MemberContext memberContext) {
        return new ResponseEntity<>(bibleService.getBibleListByMember(memberContext.getMemberIdx()), HttpStatus.OK);
    }
}
