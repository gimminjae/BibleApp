package com.bo.biblechart.repository;

import com.bo.biblechart.entity.BibleChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BibleChartRepository extends JpaRepository<BibleChart, Long> {
    List<BibleChart> findByMemberIdx(Long memberIdx);
}
