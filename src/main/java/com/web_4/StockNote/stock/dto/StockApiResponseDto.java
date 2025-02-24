package com.web_4.StockNote.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StockApiResponseDto {
    @JsonProperty("output")
    private StockData output;

    public StockDto toDto(String ticker, String companyName) {
        return new StockDto(
                ticker,
                companyName,
                output.getMarketType(),
                output.getCurrentPrice(),
                output.getHighestPrice(),
                output.getLowestPrice(),
                output.getChangeRate(),
                output.getVolume(),
                "Korea Investment API"
        );
    }
}
