package com.woowahan.currency.service;

import com.woowahan.currency.dto.*;
import com.woowahan.currency.external.ExchangeApiClient;
import com.woowahan.currency.properties.ExchangeApiProperty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.woowahan.currency.domain.Countries.KRW;
import static com.woowahan.currency.domain.Countries.USD;
import static com.woowahan.currency.fixture.ExchangeFixture.*;
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
    @DisplayName("환율정보를 조회한다")
    void retrieveExchanges_test() {
        when(exchangeApiClient.retrieve(any())).thenReturn(TEST_CURRENCY);

        RetrieveExchangeResponseDto currency = exchangeService.retrieveExchanges(USD.getName(), KRW.getName());
        FormattedQuote formatQuote = currency.getQuote();

        assertThat(currency.getSource()).isEqualTo(USD.getName());
        assertThat(formatQuote.getValue()).isEqualTo(TEST_FORMATTED_USD_KRW);

        verify(exchangeApiClient).retrieve(any());
        verify(exchangeApiProperty).getUrl();
    }

    @Test
    @DisplayName("환율을 조회하여 수취금액을 계산한다")
    void calculateRecipientAmount_test() {
        CalculateRecipientRequestDto request = CalculateRecipientRequestDto.builder()
                .exchangeRate(TEST_USD_KRW)
                .transferAmount(4000)
                .build();

        CalculateRecipientResponseDto response = exchangeService.calculateRecipientAmount(request);

        assertThat(response.getRecipientAmount())
                .isEqualTo(new FormattedQuote(TEST_USD_KRW * request.getTransferAmount()));
    }
}
