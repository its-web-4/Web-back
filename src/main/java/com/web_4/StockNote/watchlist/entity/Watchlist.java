package com.web_4.StockNote.watchlist.entity;
//DB 같은 존재
import com.web_4.StockNote.user.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "watchlist")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    //@ManyToOne
    //@JoinColumn(name = "stock_id",nullable = false)
    //  Stock Stock;

    //public Watchlist() {}

    //public Watchlist(User user, Stock stock){
    //    this.user = user;
    //    this.Stock = stock;
    //}
    @Column(name ="stock_id",nullable = false)
    private Long stockId;

    public Watchlist() {}
    public Watchlist(User user, Long stockId) {
        this.user = user;
        this.stockId = stockId;
    }
    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Long getStockId() {
        return stockId;
    }

}
