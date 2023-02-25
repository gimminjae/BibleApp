package com.bo.bible.entity;

import lombok.Getter;

@Getter
public enum BibleEnum {
    A("창세기", 50, 1, "old"),
    B("출애굽기", 40, 2, "old"),
    C("레위기", 27,3, "old"),
    D("민수기", 36, 4, "old"),
    E("신명기", 34, 5, "old");
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
