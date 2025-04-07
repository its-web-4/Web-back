package com.web_4.StockNote.watchlist.service;

import com.web_4.StockNote.user.entity.User;
import com.web_4.StockNote.watchlist.entity.Watchlist;
import com.web_4.StockNote.watchlist.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {
    private final WatchlistRepository watchlistRepository;
    public WatchlistService(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }
    public Watchlist addToWatchlist(User user, Long stockId) {
        Watchlist watchlist = new Watchlist();
        return watchlistRepository.save(watchlist);
    }
    public List<Watchlist> getUserWatchlists(Long userId) {
        return watchlistRepository.findByUserId(userId);
    }
    public void removeFromWatchlist(Long watchlistId) {
        watchlistRepository.deleteById(watchlistId);
    }
}
