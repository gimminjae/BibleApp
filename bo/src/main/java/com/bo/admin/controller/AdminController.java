package com.bo.admin.controller;

import com.bo.bible.service.BibleService;
import com.bo.biblechart.service.BibleChartService;
import com.bo.dept.entity.Dept;
import com.bo.dept.service.DeptService;
import com.bo.member.dto.MemberDto;
import com.bo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private final MemberService memberService;
    private final BibleChartService bibleChartService;
    private final BibleService bibleService;
    private final DeptService deptService;
    @GetMapping("/members/all")
    public ResponseEntity<List<MemberDto>> getAllMember() {
        return new ResponseEntity<>(memberService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/dept")
    public ResponseEntity<Void> createDept() {
        //부서 생성, but 부서는 최대 5개 까지만
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
