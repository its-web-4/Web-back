package com.web_4.StockNote.stock.controller;

import com.web_4.StockNote.stock.entity.Stock;
import com.web_4.StockNote.stock.service.StockApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockApiService stockApiService;

    @GetMapping("/{ticker}")
    public Stock fetchStock(@PathVariable String ticker) {
        return stockApiService.fetchAndSaveStockData(ticker);  // ✅ 반환 타입 확인
    }
}
