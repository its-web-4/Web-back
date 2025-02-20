package com.web_4.StockNote.watchlist.dto;

import com.web_4.StockNote.watchlist.entity.Watchlist;

public class WatchlistDTO {
    private Long id;
    private Long userId;
    private String stockSymbol;
    public WatchlistDTO(Watchlist watchlist) {
        this.id = watchlist.getId();
        this.userId = watchlist.getUser().getId();
        this.stockSymbol = watchlist.getstock().getSymbol();
    }
}
