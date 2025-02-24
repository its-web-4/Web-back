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
public class CompanyApiResponseDto {

    @JsonProperty("output") // API 응답 "output" 과 매핑
    private CompanyOutputDto output;
}