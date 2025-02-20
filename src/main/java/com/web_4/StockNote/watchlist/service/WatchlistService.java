package com.web_4.StockNote.watchlist.service;

import com.web_4.StockNote.watchlist.dto.WatchlistDTO;
import com.web_4.StockNote.watchlist.repository.WatchlistRepository;


public class WatchlistService {
    private final WatchlistRepository watchlistRepository;
    private final UserRepository userRepository;
    private final StockRepository stockRepository;
    public WatchlistService(WatchlistRepository watchlistRepository,UserRepository userRepository,StockRepository stockRepository){
        this.watchlistRepository = watchlistRepository;
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
    }
    public List<WatchlistDTO> getUserWatchlist(Long userId){
        List<Watchlist> watchlistList = watchlistRepository.findByUserId(userId);
        return watchlist.stream().map(WatchlistDTO::new).collect(Collectors.toList);
    }
    public List<WatchlistDTO> addStockToWatchlist(Long userId,Long stockId){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        Stock stock = stockRspoitory.findById(stockId).orElseThrow(()->new RuntimeException("Stock not found"));
        Watchlist watchlist = new Watchlist(user,stock);
        watchlistRepository.save(watchlist);
        return new Watchlist(user,stock);
    }
    public void removeStockFromWatchlist(Long watchlistId){
        watchlistRepository.deleteById(watchlistId);
    }
}
