package com.woowahan.currency.service;

import com.woowahan.currency.dto.CurrencyResponseDto;
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

    public CurrencyResponseDto retrieveExchanges() {
        return exchangeApiClient.retrieve(apiProperty.getUrl());
    }
}