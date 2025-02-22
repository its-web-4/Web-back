package com.web_4.StockNote.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockApiResponseDto { // API 응답의 최상위 데이터를 받음
    @JsonProperty("output")
    private StockData output;

    public  StockDto toDto() {
        return new StockDto(
                output.getTicker(),
                output.getCompanyName(),
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
