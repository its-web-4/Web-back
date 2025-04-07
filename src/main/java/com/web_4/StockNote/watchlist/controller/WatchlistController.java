package com.web_4.StockNote.watchlist.controller;

import com.web_4.StockNote.user.entity.User;
import com.web_4.StockNote.watchlist.entity.Watchlist;
import com.web_4.StockNote.watchlist.service.WatchlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    private final WatchlistService watchlistService;
    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }
    @PostMapping("/add")
    public Watchlist addToWatchlist(@RequestParam Long userId, @RequestParam Long stockId) {
        User user = new User();  // 실제 프로젝트에서는 UserService 등을 통해 가져와야 함
        user.setId(userId);
        return watchlistService.addToWatchlist(user, stockId);
    }
    @GetMapping("/user/{userId}")
    public List<Watchlist> getWatchlist(@PathVariable Long userId){
        return watchlistService.getUserWatchlists(userId);
    }
    @DeleteMapping("/remove/{watchlistId}")
    public void removeFromWatchlist(@PathVariable Long watchlistId){
        watchlistService.removeFromWatchlist(watchlistId);
    }

}
