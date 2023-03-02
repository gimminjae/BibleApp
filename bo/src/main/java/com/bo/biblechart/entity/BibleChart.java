package com.bo.biblechart.entity;

import com.bo.biblechart.dto.BibleChartDto;
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

    public static BibleChart from(BibleChartDto bibleChartDto) {
        return BibleChart.builder()
                .chartName(bibleChartDto.getChartName())
                .deptIdx(bibleChartDto.getDeptIdx())
                .memberIdx(bibleChartDto.getMemberIdx())
                .build();
    }
    //시작일
    //종료일
    //달성률
    public BibleChartDto toDto() {
        return BibleChartDto.builder()
                .bibleChartIdx(this.getBibleChartIdx())
                .chartName(this.getChartName())
                .deptIdx(this.getDeptIdx())
                .memberIdx(this.getMemberIdx())
                .build();
    }

}
