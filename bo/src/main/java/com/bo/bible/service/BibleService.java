package com.bo.bible.service;

import com.bo.bible.entity.Bible;
import com.bo.bible.entity.BibleEnum;
import com.bo.bible.repository.BibleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bo.bible.entity.Bible.newBible;

@Service
@RequiredArgsConstructor
public class BibleService {
    private final BibleRepository bibleRepository;

    public void addBiblesAtMember(Long memberIdx) {
        bibleRepository.save(newBible(BibleEnum.A, memberIdx));
        bibleRepository.save(newBible(BibleEnum.B, memberIdx));
        bibleRepository.save(newBible(BibleEnum.C, memberIdx));
        bibleRepository.save(newBible(BibleEnum.D, memberIdx));
        bibleRepository.save(newBible(BibleEnum.E, memberIdx));
    }

    public List<Bible> getBibleListByMember(Long memberIdx) {
        return bibleRepository.findByMemIdxOrderBySequence(memberIdx);
    }
}
