package com.bo.dept.dto;

import com.bo.member.dto.MemberDto;
import com.bo.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptDto {
    private Long deptIdx;
    private String deptName;
    private String year;
    private int deptMemCount;
    private List<MemberDto> coreMem;
}
