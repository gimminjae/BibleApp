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
        bibleRepository.save(newBible(BibleEnum.New1, memberIdx, bibleChartIdx));
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
}
