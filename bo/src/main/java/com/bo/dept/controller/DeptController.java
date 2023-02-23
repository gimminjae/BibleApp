package com.bo.dept.controller;

import com.bo.dept.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dept")
public class DeptController {
    private final DeptService deptService;
}
