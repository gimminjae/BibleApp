package com.bo.bible.entity;

import lombok.Getter;

@Getter
public enum BibleEnum {
    Old1("창세기", 50, 1, "old"),
    Old2("출애굽기", 40, 2, "old"),
    Old3("레위기", 27,3, "old"),
    Old4("민수기", 36, 4, "old"),
    Old5("신명기", 34, 5, "old"),
    New1("마태복음", 28, 1, "new");
    private String name;
    private Integer count;
    private Integer sequence;
    private String version;
    BibleEnum(String name, Integer count, Integer sequence, String version) {
        this.name = name;
        this.count = count;
        this.sequence = sequence;
        this.version = version;
    }
}
