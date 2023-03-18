package com.bo.biblechart.service;

import com.bo.bible.service.BibleService;
import com.bo.biblechart.dto.BibleChartDto;
import com.bo.biblechart.entity.BibleChart;
import com.bo.biblechart.repository.BibleChartRepository;
import com.bo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
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

    public void remove(Long memberIdx, long bibleChartIdx) {
        BibleChart bibleChart = bibleChartRepository.findById(bibleChartIdx).orElse(null);
        if(bibleChart == null) {
            throw new NullPointerException("데이터가 존재하지 않습니다.");
        }
        if(!bibleChart.getMemberIdx().equals(memberIdx)) {
            throw new AccessDeniedException("삭제 권한이 없습니다.");
        }
        bibleChartRepository.delete(bibleChart);

        bibleService.removeByBibleChartIdx(bibleChart.getBibleChartIdx());
    }
}
