package com.bo.bible.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BibleDto {
    private Long bibleIdx;
    private Integer sequence;
    private String bibleName;
    private List<Integer> readList;
    private Integer totalCount;
    private String version;
    private Long bibleChartIdx;
}
