package com.web_4.StockNote.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
@RequiredArgsConstructor
public class StockApiService {
    private final RestTemplate restTemplate;

    @Value("${koreainvestment.api.base-url}")
    private String baseUrl;

    @Value("${koreainvestment.api.app-key}")
    private String appKey;

    @Value("${koreainvestment.api.app-secret}")
    private String appSecret;

    @Value("${koreainvestment.api.access-token}")
    private String accessToken;

    public String fetchStockData(String ticker) {
        String url = baseUrl + "/uapi/domestic-stock/v1/quotations/inquire-price?FID_COND_MRKT_DIV_CODE=J&FID_INPUT_ISCD=" + ticker;

        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", "Bearer " + accessToken);
        headers.set("appkey", appKey);
        headers.set("appsecret", appSecret);
        headers.set("tr_id", "FHKST01010100");
        headers.set("custtype", "P");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class
        );

        return response.getBody();  // API 응답 JSON 반환
    }
}

