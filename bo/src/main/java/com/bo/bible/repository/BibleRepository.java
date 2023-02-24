package com.bo.bible.repository;

import com.bo.bible.entity.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibleRepository extends JpaRepository<Bible, Long> {
    List<Bible> findByMemIdxOrderBySequence(Long memberIdx);
}
