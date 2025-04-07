package com.web_4.StockNote.watchlist.dto;

public class WatchlistRequestDTO {
    private Long userid;
    private Long stockId;

    public WatchlistRequestDTO() {}
    public WatchlistRequestDTO(Long userid, Long stockId) {
        this.userid = userid;
        this.stockId = stockId;
    }
    public Long getUserid() {
        return userid;
    }
    public Long getStockId() {
        return stockId;
    }
}
