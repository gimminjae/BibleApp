package com.bo.biblechart.service;

import com.bo.bible.service.BibleService;
import com.bo.biblechart.dto.BibleChartDto;
import com.bo.biblechart.entity.BibleChart;
import com.bo.biblechart.repository.BibleChartRepository;
import com.bo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibleChartService {
    private final BibleChartRepository bibleChartRepository;
    private final BibleService bibleService;

    public BibleChartDto create(BibleChartDto bibleChartDto) {
        BibleChart bibleChart = BibleChart.from(bibleChartDto);
        BibleChart bibleChart1 = bibleChartRepository.save(bibleChart);

        return bibleChart1.toDto();
    }

    public List<BibleChartDto> getByMemberIdx(Long memberIdx) {
        return bibleChartRepository.findByMemberIdx(memberIdx).stream().map(BibleChart::toDto).toList();
    }
}
