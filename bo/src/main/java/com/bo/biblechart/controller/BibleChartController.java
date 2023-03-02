package com.bo.biblechart.controller;

import com.bo.biblechart.service.BibleChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/biblechart")
public class BibleChartController {
    private final BibleChartService bibleChartService;
}
