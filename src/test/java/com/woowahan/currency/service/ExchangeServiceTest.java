package com.woowahan.currency.service;

import com.woowahan.currency.dto.CurrencyResponseDto;
import com.woowahan.currency.external.ExchangeApiClient;
import com.woowahan.currency.properties.ExchangeApiProperty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.woowahan.currency.domain.Countries.USD;
import static com.woowahan.currency.fixture.ExchangeFixture.TEST_CURRENCY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangeServiceTest {

    @InjectMocks
    private ExchangeService exchangeService;

    @Mock
    private ExchangeApiClient exchangeApiClient;

    @Spy
    private ExchangeApiProperty exchangeApiProperty;

    @Test
    @DisplayName("환율정보를 ")
    void retrieve_exchanges() {
        when(exchangeApiClient.retrieve(any())).thenReturn(TEST_CURRENCY);

        CurrencyResponseDto response = exchangeService.retrieveExchanges();

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getSource()).isEqualTo(USD.getName());

        verify(exchangeApiClient).retrieve(any());
        verify(exchangeApiProperty).getUrl();
        verify(exchangeApiClient).retrieve(any());
    }
}
