package com.bo.biblechart.service;

import com.bo.biblechart.repository.BibleChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BibleChartService {
    private final BibleChartRepository bibleChartRepository;
}
