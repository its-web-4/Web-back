package com.web_4.StockNote.watchlist.entity;
//DB 같은 존재
import jakarta.persistence.*;

@Entity
@Table(name = "watchlist")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private  User user;

    @ManyToOne
    @JoinColumn(name = "stock_id",nullable = false)
    private  Stock Stock;

    public Watchlist() {}

    public Watchlist(User user, Stock stock){
        this.user = user;
        this.Stock = stock;
    }
}
