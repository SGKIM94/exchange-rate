package com.woowahan.currency.service;

import com.woowahan.currency.dto.CalculateRecipientRequestDto;
import com.woowahan.currency.dto.CalculateRecipientResponseDto;
import com.woowahan.currency.dto.CurrencyResponseDto;
import com.woowahan.currency.external.ExchangeApiClient;
import com.woowahan.currency.properties.ExchangeApiProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.woowahan.currency.domain.Countries.*;

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
        CurrencyResponseDto currencyResponse = retrieveExchanges();

        if (request.getRecipientCountry().equals(KRW)) {
            return CalculateRecipientResponseDto
                    .toDto(currencyResponse.getQuotes().getUSDKRW() * request.getTransferAmount());
        } else if (request.getRecipientCountry().equals(JPY)) {
            return CalculateRecipientResponseDto
                    .toDto(currencyResponse.getQuotes().getUSDJPY() * request.getTransferAmount());
        } else if (request.getRecipientCountry().equals(PHP)) {
            return CalculateRecipientResponseDto
                    .toDto(currencyResponse.getQuotes().getUSDPHP() * request.getTransferAmount());
        }

        throw new IllegalArgumentException("잘못된 수취국가입니다.");
    }

    public CurrencyResponseDto retrieveExchanges() {
        return exchangeApiClient.retrieve(apiProperty.getUrl());
    }
}
