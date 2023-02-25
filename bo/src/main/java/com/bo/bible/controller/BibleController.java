package com.bo.bible.controller;

import com.bo.bible.dto.BibleDto;
import com.bo.bible.entity.Bible;
import com.bo.bible.service.BibleService;
import com.bo.member.entity.Member;
import com.bo.member.entity.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bible")
public class BibleController {
    private final BibleService bibleService;

    @GetMapping("/{version}")
    public ResponseEntity<List<BibleDto>> getBibleListByMember(@AuthenticationPrincipal MemberContext memberContext, @PathVariable String version) {
        return new ResponseEntity<>(bibleService.getBibleListByMember(memberContext.getMemberIdx(), version), HttpStatus.OK);
    }
    @PostMapping("/save/{bibleIdx}")
    public ResponseEntity<Object> saveReadBible(@AuthenticationPrincipal MemberContext memberContext,
                                                @PathVariable Long bibleIdx, @RequestBody Map<String, String> readList) {
        //저장
        bibleService.save(bibleIdx, readList.get("readList"));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
