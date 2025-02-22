package com.web_4.StockNote.stock.repository;

import com.web_4.StockNote.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByTicker(String ticker); // 주식 코드로 조회
}
