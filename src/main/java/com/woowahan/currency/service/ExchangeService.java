package com.woowahan.currency.service;

import com.woowahan.currency.dto.CalculateRecipientRequestDto;
import com.woowahan.currency.dto.CalculateRecipientResponseDto;
import com.woowahan.currency.dto.CurrencyResponseDto;
import com.woowahan.currency.dto.RetrieveExchangeResponseDto;
import com.woowahan.currency.external.ExchangeApiClient;
import com.woowahan.currency.properties.ExchangeApiProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExchangeService {
    private ExchangeApiClient exchangeApiClient;
    private ExchangeApiProperty apiProperty;

    public ExchangeService(ExchangeApiClient exchangeApiClient, ExchangeApiProperty apiProperty) {
        this.exchangeApiClient = exchangeApiClient;
        this.apiProperty = apiProperty;
    }

    public CalculateRecipientResponseDto calculateRecipientAmount(CalculateRecipientRequestDto request) {
        return CalculateRecipientResponseDto.toDto(request.getExchangeRate() * request.getTransferAmount());
    }

    public RetrieveExchangeResponseDto retrieveExchanges(String source, String destination) {
        String url = makeExchangeUrl(apiProperty.getUrl(), source, destination);
        CurrencyResponseDto retrieve = exchangeApiClient.retrieve(url);

        return RetrieveExchangeResponseDto.toDto(retrieve, source, destination);
    }

    private String makeExchangeUrl(String url, String source, String destination) {
        return url + "&source=" + source + "&currencies=" + destination;
    }
}
