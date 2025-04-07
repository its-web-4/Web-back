package com.web_4.StockNote.watchlist.dto;

public class WatchlistResponseDTO {
    private  Long watchlistId;
    private  Long stockId;

    public WatchlistResponseDTO(Long watchlistId, Long stockId) {
        this.watchlistId = watchlistId;
        this.stockId = stockId;
    }
    public Long getWatchlistId() {
        return watchlistId;
    }
    public Long getStockId(){
        return stockId;
    }
}
