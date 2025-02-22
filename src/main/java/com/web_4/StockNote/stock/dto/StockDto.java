package com.web_4.StockNote.stock.dto;

import com.web_4.StockNote.stock.entity.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto { // API 응답 데이터 추출 후 엔티티 변환
    private String ticker;
    private String companyName;
    private String marketType;
    private BigDecimal currentPrice;
    private BigDecimal highestPrice;
    private BigDecimal lowestPrice;
    private BigDecimal changeRate;
    private Long volume;
    private String source;

    public Stock toEntity() {
        return new Stock(
                null,
                ticker,
                companyName,
                marketType,
                currentPrice,
                highestPrice,
                lowestPrice,
                changeRate,
                volume,
                source,
                null);
    }
}
