package com.bo.bible.entity;

import lombok.Getter;

@Getter
public enum BibleEnum {
    Old1("창세기", 50, 1, "old"),
    Old2("출애굽기", 40, 2, "old"),
    Old3("레위기", 27, 3, "old"),
    Old4("민수기", 36, 4, "old"),
    Old5("신명기", 34, 5, "old"),
    Old6("여호수아", 24, 6, "old"),
    Old7("사사기", 21, 7, "old"),
    Old8("룻기", 4, 8, "old"),
    Old9("사무엘상", 31, 9, "old"),
    Old10("사무엘하", 24, 10, "old"),
    Old11("열왕기상", 22, 11, "old"),
    Old12("열왕기하", 25, 12, "old"),
    Old13("역대상", 29, 13, "old"),
    Old14("역대하", 36, 14, "old"),
    Old15("에스라", 10, 15, "old"),
    Old16("느헤미야", 13, 16, "old"),
    Old17("에스더", 10, 17, "old"),
    Old18("욥기", 42, 18, "old"),
    Old19("시편", 150, 19, "old"),
    Old20("잠언", 31, 20, "old"),
    Old21("전도서", 12, 21, "old"),
    Old22("아가", 8, 22, "old"),
    Old23("이사야", 66, 23, "old"),
    Old24("예레미야", 52, 24, "old"),
    Old25("예레미야 애가", 5, 25, "old"),
    Old26("에스겔", 48, 26, "old"),
    Old27("다니엘", 12, 27, "old"),
    Old28("호세아", 14, 28, "old"),
    Old29("요엘", 3, 29, "old"),
    Old30("아모스", 9, 30, "old"),
    Old31("오바댜", 1, 31, "old"),
    Old32("요나", 4, 32, "old"),
    Old33("미가", 7, 33, "old"),
    Old34("나훔", 3, 34, "old"),
    Old35("하박국", 3, 35, "old"),
    Old36("스바냐", 3, 36, "old"),
    Old37("학개", 2, 37, "old"),
    Old38("스가랴", 14, 38, "old"),
    Old39("말라기", 4, 39, "old"),
    New1("마태복음", 28, 40, "new"),
    New2("마가복음", 16, 41, "new"),
    New3("누가복음", 24, 42, "new"),
    New4("요한복음", 21, 43, "new"),
    New5("사도행전", 28, 44, "new"),
    New6("로마서", 16, 45, "new"),
    New7("고린도전서", 16, 46, "new"),
    New8("고린도후서", 13, 47, "new"),
    New9("갈라디아서", 6, 48, "new"),
    New10("에베소서", 6, 49, "new"),
    New11("빌립보서", 4, 50, "new"),
    New12("골로새서", 4, 51, "new"),
    New13("데살로니가전서", 5, 52, "new"),
    New14("데살로니가후서", 3, 53, "new"),
    New15("디모데전서", 6, 54, "new"),
    New16("디모데후서", 4, 55, "new"),
    New17("디도서", 3, 56, "new"),
    New18("빌레몬서", 1, 57, "new"),
    New19("히브리서", 13, 58, "new"),
    New20("야고보서", 5, 59, "new"),
    New21("베드로전서", 5, 60, "new"),
    New22("베드로후서", 3, 61, "new"),
    New23("요한1서", 5, 62, "new"),
    New24("요한2서", 1, 63, "new"),
    New25("요한3서", 1, 64, "new"),
    New26("유다서", 1, 65, "new"),
    New27("요한계시록", 22, 66, "new");
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
