package com.web_4.StockNote.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockData { // API 응답에서 내부 데이터를 매핑
    @JsonProperty("shrn_iscd")  // 단축코드 (티커 역할)
    private String ticker;

    @JsonProperty("bstp_kor_isnm")
    private String marketType;

    @JsonProperty("stck_prpr")
    private BigDecimal currentPrice;

    @JsonProperty("stck_hgpr")
    private BigDecimal highestPrice;

    @JsonProperty("stck_lwpr")
    private BigDecimal lowestPrice;

    @JsonProperty("prdy_ctrt")
    private BigDecimal changeRate;

    @JsonProperty("acml_vol")
    private Long volume;
}

