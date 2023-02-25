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

    public void addBiblesAtMember(Long memberIdx) {
        bibleRepository.save(newBible(BibleEnum.A, memberIdx));
        bibleRepository.save(newBible(BibleEnum.B, memberIdx));
        bibleRepository.save(newBible(BibleEnum.C, memberIdx));
        bibleRepository.save(newBible(BibleEnum.D, memberIdx));
        bibleRepository.save(newBible(BibleEnum.E, memberIdx));
    }

    public List<BibleDto> getBibleListByMember(Long memberIdx) {
        return bibleRepository.findByMemIdxOrderBySequence(memberIdx).stream().map(Bible::toDto).toList();
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
}
