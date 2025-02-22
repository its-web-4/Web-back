package com.web_4.StockNote.stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId; // 주식 고유 id

    @Column(unique = true, nullable = false, length = 20)
    private String ticker; // 주식 코드

    @Column(nullable = false, length = 100)
    private String companyName; // 회사이름

    @Column(nullable = false, length = 50)
    private String marketType; // 코스피, 코스닥 등

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal currentPrice; // 현재 가격

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal highestPrice; // 최고가

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal lowestPrice; // 최저가

    @Column(nullable = false, precision = 7, scale = 3)
    private BigDecimal changeRate; // 전일 대비 등락률

    @Column(nullable = false)
    private Long volume; // 거래량

    @Column(nullable = false)
    private String source; // API 출처

    @UpdateTimestamp
    private Timestamp updatedAt;

    // @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    //  private List<Watchlist> watchlist = new ArrayList<>();
}
