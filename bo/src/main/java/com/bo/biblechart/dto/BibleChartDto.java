package com.bo.biblechart.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BibleChartDto {
    private Long bibleChartIdx;
    private String chartName;
    private Long memberIdx;
    private Long deptIdx;
}
