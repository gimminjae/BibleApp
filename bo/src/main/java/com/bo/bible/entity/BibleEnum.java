package com.bo.bible.entity;

import lombok.Getter;

@Getter
public enum BibleEnum {
    A("창세기", 50, 1),
    B("출애굽기", 40, 2),
    C("레위기", 27,3),
    D("민수기", 36, 4),
    E("신명기", 34, 5);
    private String name;
    private Integer count;
    private Integer sequence;
    BibleEnum(String name, Integer count, Integer sequence) {
        this.name = name;
        this.count = count;
        this.sequence = sequence;
    }
}
