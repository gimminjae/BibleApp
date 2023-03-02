package com.bo.biblechart.controller;

import com.bo.bible.dto.BibleDto;
import com.bo.bible.entity.Bible;
import com.bo.bible.service.BibleService;
import com.bo.biblechart.dto.BibleChartDto;
import com.bo.biblechart.entity.BibleChart;
import com.bo.biblechart.service.BibleChartService;
import com.bo.dept.service.DeptService;
import com.bo.member.dto.MemberDto;
import com.bo.member.entity.Member;
import com.bo.member.entity.MemberContext;
import com.bo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.metamodel.mapping.internal.VirtualIdEmbeddable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/biblechart")
public class BibleChartController {
    private final BibleChartService bibleChartService;
    private final MemberService memberService;
    private final BibleService bibleService;
    private final DeptService deptService;

//    @PostMapping("")
//    public ResponseEntity<Void> createBibleChart(@AuthenticationPrincipal MemberContext memberContext, BibleChartDto bibleChartDto) {
//        bibleChartService.create(bibleChartDto);
//
//        List<MemberDto> memberList = null;
//
//        if (bibleChartDto.getDeptIdx() == null && bibleChartDto.getMemberIdx() == null) {
//            memberList = memberService.getAll();
//        } else if(bibleChartDto.getDeptIdx() != null && bibleChartDto.getDeptIdx() != 0) {
//            memberList = memberService.getByDeptIdx(bibleChartDto.getDeptIdx());
//        }
//        if(memberList != null) {
//            //권한 검사
//            if(!memberContext.getRole().equals("SUBADMIN") && !memberContext.getRole().equals("ADMIN")) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//            for(MemberDto memberDto : memberList) {
//                bibleService.addBiblesAtMember(memberDto.getMemberIdx(), bibleChartDto.getBibleChartIdx());
//            }
//        } else {
//            bibleService.addBiblesAtMember(memberContext.getMemberIdx(), bibleChartDto.getBibleChartIdx());
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PostMapping("")
    public ResponseEntity<Void> createBibleChart(@AuthenticationPrincipal MemberContext memberContext, @RequestBody BibleChartDto inputBibleChartDto) {
        inputBibleChartDto.setMemberIdx(memberContext.getMemberIdx());
        BibleChartDto bibleChartDto = bibleChartService.create(inputBibleChartDto);
        bibleService.addBiblesAtMember(memberContext.getMemberIdx(), bibleChartDto.getBibleChartIdx());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/member")
    public ResponseEntity<List<BibleChartDto>> getBibleChartByMemberIdx(@AuthenticationPrincipal MemberContext memberContext) {
        List<BibleChartDto> bibleChartDtos = bibleChartService.getByMemberIdx(memberContext.getMemberIdx());

        return new ResponseEntity<>(bibleChartDtos, HttpStatus.OK);
    }
    @GetMapping("/{bibleChartIdx}")
    public ResponseEntity<List<BibleDto>> getBibleListByChartIdx(@AuthenticationPrincipal MemberContext memberContext, @PathVariable Long bibleChartIdx, @RequestParam String version) {
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
