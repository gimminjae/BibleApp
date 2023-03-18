package com.bo.dept.entity;

import com.bo.dept.dto.DeptDto;
import com.bo.member.dto.MemberDto;
import com.bo.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptIdx;
    private String deptName;
    private String year;
    private int deptMemCount;
//    @OneToMany
//    private List<Member> coreMem;
    public DeptDto toDto() {
        return DeptDto.builder()
                .deptIdx(this.getDeptIdx())
                .deptName(this.getDeptName())
                .year(this.getYear())
                .deptMemCount(this.getDeptMemCount())
//                .coreMem(this.getCoreMem().stream().map(Member::toDto).toList())
                .build();
    }
}
