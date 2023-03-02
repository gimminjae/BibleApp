package com.bo.biblechart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BibleChart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bibleChartIdx;
    private String chartName;
    private Long memberIdx;
    private Long deptIdx;
    //시작일
    //종료일
    //달성률

}
