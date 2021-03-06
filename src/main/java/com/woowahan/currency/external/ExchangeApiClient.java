package com.woowahan.currency.external;

import com.woowahan.currency.dto.CurrencyResponseDto;
import com.woowahan.currency.service.ApiClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.NotAcceptableStatusException;

import java.net.URI;

@Component
public class ExchangeApiClient implements ApiClient {

    private RestTemplate restTemplate;

    public ExchangeApiClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    @Override
    public CurrencyResponseDto retrieve(String url) {
        URI uri = URI.create(url);

        CurrencyResponseDto response = restTemplate.getForEntity(uri, CurrencyResponseDto.class)
                .getBody();

        if (response == null) {
            throw new NotAcceptableStatusException("환율정보를 조회 시 응답을 받지 못하였습니다.");
        }

        if (!response.isSuccess()) {
            throw new IllegalStateException("환율정보 응답을 성공 값으로 받지 못했습니다." + response.toString());
        }

        return response;
    }
}
