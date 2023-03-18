package com.bo.bible.service;

import com.bo.bible.dto.BibleDto;
import com.bo.bible.entity.Bible;
import com.bo.bible.entity.BibleEnum;
import com.bo.bible.repository.BibleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Optional;

import static com.bo.bible.entity.Bible.newBible;

@Service
@RequiredArgsConstructor
public class BibleService {
    private final BibleRepository bibleRepository;

    public void addBiblesAtMember(Long memberIdx, Long bibleChartIdx) {

        bibleRepository.save(newBible(BibleEnum.Old1, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old2, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old3, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old4, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old5, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old6, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old7, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old8, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old9, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old10, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old11, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old12, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old13, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old14, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old15, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old16, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old17, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old18, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old19, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old20, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old21, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old22, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old23, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old24, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old25, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old26, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old27, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old28, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old29, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old30, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old31, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old32, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old33, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old34, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old35, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old36, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old37, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old38, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.Old39, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New1, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New2, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New3, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New4, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New5, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New6, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New7, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New8, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New9, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New10, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New11, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New12, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New13, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New14, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New15, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New16, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New17, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New18, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New19, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New20, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New21, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New22, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New23, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New24, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New25, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New26, memberIdx, bibleChartIdx));
        bibleRepository.save(newBible(BibleEnum.New27, memberIdx, bibleChartIdx));
    }

    public List<BibleDto> getBibleListByMember(Long memberIdx, String version) {
        return bibleRepository.findByMemIdxAndVersionOrderBySequence(memberIdx, version).stream().map(Bible::toDto).toList();
    }

    public void save(Long bibleIdx, String readList) {
        Optional<Bible> optionalBible = bibleRepository.findById(bibleIdx);

        if(optionalBible.isPresent()) {
            Bible bible = optionalBible.get();
            bible.update(readList);
            bibleRepository.save(bible);
        } else {
            throw new NullPointerException("데이터가 존재하지 않습니다.");
        }
    }

    public BibleDto getByBibleIdx(Long bibleIdx) {
        return bibleRepository.findById(bibleIdx).orElse(null).toDto();
    }

    public List<BibleDto> getBibleListByBibleChartIdx(Long bibleChartIdx, String version) {
        return bibleRepository.findByBibleChartIdxAndVersionOrderBySequence(bibleChartIdx, version).stream().map(Bible::toDto).toList();
    }

    public void removeByBibleChartIdx(Long bibleChartIdx) {
        List<Bible> bibleList = bibleRepository.findByBibleChartIdx(bibleChartIdx);

        bibleList.stream().forEach(i -> bibleRepository.delete(i));
    }
}
