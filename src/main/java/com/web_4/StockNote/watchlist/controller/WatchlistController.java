package com.web_4.StockNote.watchlist.controller;

import com.web_4.StockNote.watchlist.service.WatchlistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    private final WatchlistService watchlistService;
}
