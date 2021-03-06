package com.woowahan.currency.service;

import com.woowahan.currency.dto.CalculateRecipientRequestDto;
import com.woowahan.currency.dto.CalculateRecipientResponseDto;
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

import static com.woowahan.currency.domain.Countries.KRW;
import static com.woowahan.currency.domain.Countries.USD;
import static com.woowahan.currency.fixture.ExchangeFixture.TEST_CURRENCY;
import static com.woowahan.currency.fixture.ExchangeFixture.TEST_USD_KRW;
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

        CurrencyResponseDto response = exchangeService.retrieveExchanges();

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getSource()).isEqualTo(USD.getName());

        verify(exchangeApiClient).retrieve(any());
        verify(exchangeApiProperty).getUrl();
    }

    @Test
    @DisplayName("환율을 조회하여 수취금액을 계산한다")
    void calculateRecipientAmount_test() {
        when(exchangeApiClient.retrieve(any())).thenReturn(TEST_CURRENCY);

        CalculateRecipientRequestDto request = CalculateRecipientRequestDto.builder()
                .recipientCountry(KRW.getName())
                .transferAmount(4000)
                .build();

        CalculateRecipientResponseDto response = exchangeService.calculateRecipientAmount(request);

        assertThat(response.getRecipientAmount()).isEqualTo(TEST_USD_KRW * request.getTransferAmount());

        verify(exchangeApiClient).retrieve(any());
        verify(exchangeApiProperty).getUrl();
        verify(exchangeService).retrieveExchanges();
    }
}
