package com.web_4.StockNote.stock.controller;

import com.web_4.StockNote.stock.service.StockApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockApiService stockApiService;

    @GetMapping("/{ticker}")
    public ResponseEntity<String> testStockApi(@PathVariable String ticker) {
        String response = stockApiService.fetchStockData(ticker);
        return ResponseEntity.ok(response);
    }
}
