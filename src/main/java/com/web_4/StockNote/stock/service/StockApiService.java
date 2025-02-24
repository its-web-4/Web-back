package com.web_4.StockNote.stock.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web_4.StockNote.stock.dto.CompanyApiResponseDto;
import com.web_4.StockNote.stock.dto.StockApiResponseDto;
import com.web_4.StockNote.stock.dto.StockDto;
import com.web_4.StockNote.stock.entity.Stock;
import com.web_4.StockNote.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockApiService {
    private final RestTemplate restTemplate;
    private final StockRepository stockRepository;

    // 외부 환경설정 값 주입
    @Value("${koreainvestment.api.base-url}")
    private String baseUrl;

    @Value("${koreainvestment.api.app-key}")
    private String appKey;

    @Value("${koreainvestment.api.app-secret}")
    private String appSecret;

    @Value("${koreainvestment.api.access-token}")
    private String accessToken;

    public Stock fetchAndSaveStockData(String ticker) {
        String priceUrl = baseUrl + "/uapi/domestic-stock/v1/quotations/inquire-price?FID_COND_MRKT_DIV_CODE=J&FID_INPUT_ISCD=" + ticker;
        HttpHeaders headers = createHeaders("FHKST01010100");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<StockApiResponseDto> response = restTemplate.exchange(
                priceUrl, HttpMethod.GET, entity, StockApiResponseDto.class
        );

        String companyName = fetchCompanyName(ticker);
        StockDto stockDto = response.getBody().toDto(ticker, companyName);


        // 기존 DB에 해당 ticker가 존재하는지 확인
        Optional<Stock> existingStock = stockRepository.findByTicker(ticker);
        if (existingStock.isPresent()) {
            Stock stock = existingStock.get();
            stock.updateFromDto(stockDto); // 기존 데이터 업데이트
            return stockRepository.save(stock);
        }

        // 존재하지 않으면 새로 저장
        Stock stock = stockDto.toEntity();
        return stockRepository.save(stock);
    }

    private String fetchCompanyName(String ticker) {
        String companyUrl = baseUrl + "/uapi/domestic-stock/v1/quotations/search-info?PDNO=" + ticker + "&PRDT_TYPE_CD=300";
        HttpHeaders headers = createHeaders("CTPF1604R");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                companyUrl, HttpMethod.GET, entity, String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CompanyApiResponseDto responseBody = objectMapper.readValue(response.getBody(), CompanyApiResponseDto.class);
            return responseBody.getOutput().getCompanyName();
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private HttpHeaders createHeaders(String trId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", "Bearer " + accessToken);
        headers.set("appkey", appKey);
        headers.set("appsecret", appSecret);
        headers.set("tr_id", trId); // 요청별 다른 tr_id 적용
        headers.set("custtype", "P");
        return headers;
    }
}