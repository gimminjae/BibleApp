package com.bo.bible.repository;

import com.bo.bible.entity.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BibleRepository extends JpaRepository<Bible, Long> {
    List<Bible> findByMemIdxOrderBySequence(Long memberIdx);

    List<Bible> findByMemIdxAndVersionOrderBySequence(Long memberIdx, String version);

    List<Bible> findByBibleChartIdxAndVersionOrderBySequence(Long bibleChartIdx, String version);

    List<Bible> findByBibleChartIdx(Long bibleChartIdx);


    void deleteByBibleChartIdx(Long bibleChartIdx);
}
