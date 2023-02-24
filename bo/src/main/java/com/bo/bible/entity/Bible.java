package com.bo.bible.entity;

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
public class Bible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bibleIdx;
    private Integer sequence;
    private String bibleName;
    private Integer totalCount;
    private String readString;
    private Integer readCount;
    private Integer readPercent;
    private Long memIdx;
//    @OneToMany
//    private List<BiblePage> biblePageList;
    public static Bible newBible(BibleEnum bibleEnum, long memIdx) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <= bibleEnum.getCount(); i++) {
            sb.append("0 ");
        }
        return Bible.builder()
                .bibleName(bibleEnum.getName())
                .totalCount(bibleEnum.getCount())
                .sequence(bibleEnum.getSequence())
                .readString(sb.toString())
                .memIdx(memIdx)
                .build();
    }
}
