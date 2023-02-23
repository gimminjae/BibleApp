package com.bo.dept.service;

import com.bo.dept.repository.DeptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeptService {
    private final DeptRepository deptRepository;
}
