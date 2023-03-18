package com.bo.bible.entity;

import com.bo.bible.dto.BibleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
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
    @Column(columnDefinition = "LONGTEXT")
    private String readString;
    private Integer readCount;
    private Integer readPercent;
    private Long memIdx;
    private String version;
    private Long bibleChartIdx;
//    @OneToMany
//    private List<BiblePage> biblePageList;
    public static Bible newBible(BibleEnum bibleEnum, long memIdx, long bibleChartIdx) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <= bibleEnum.getCount(); i++) {
            sb.append("0,");
        }
        return Bible.builder()
                .bibleName(bibleEnum.getName())
                .totalCount(bibleEnum.getCount())
                .sequence(bibleEnum.getSequence())
                .readString(sb.toString())
                .memIdx(memIdx)
                .version(bibleEnum.getVersion())
                .bibleChartIdx(bibleChartIdx)
                .build();
    }
    public BibleDto toDto() {
        List<Integer> readList = Arrays.stream(this.getReadString().split(",")).map(Integer::valueOf).toList();

        return BibleDto.builder()
                .bibleIdx(this.getBibleIdx())
                .bibleName(this.getBibleName())
                .totalCount(this.getTotalCount())
                .readList(readList)
                .sequence(this.getSequence())
                .version(this.getVersion())
                .bibleChartIdx(this.getBibleChartIdx())
                .memIdx(this.getMemIdx())
                .readPercent(this.getReadPercent())
                .build();
    }

    public void update(String readList) {
        String[] arr = readList.split(",");

        long newReadcount = Arrays.stream(arr).filter(i -> !i.equals("0")).count();

        this.readString = readList;
        this.readCount = (int)newReadcount;
        this.readPercent = (int)(((float)this.readCount / (float)this.totalCount) * 100);
    }
}
