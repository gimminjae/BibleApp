package com.bo.biblechart.repository;

import com.bo.biblechart.entity.BibleChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibleChartRepository extends JpaRepository<BibleChart, Long> {
}
