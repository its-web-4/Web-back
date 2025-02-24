package com.web_4.StockNote.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyOutputDto {
    @JsonProperty("shrn_iscd")
    private String ticker;

    @JsonProperty("prdt_abrv_name")
    private String companyName;
}