package com.woowahan.currency.controller;

import com.woowahan.currency.dto.CalculateRecipientRequestDto;
import com.woowahan.currency.dto.CalculateRecipientResponseDto;
import com.woowahan.currency.dto.RetrieveExchangeResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static com.woowahan.currency.domain.Countries.USD;
import static com.woowahan.currency.fixture.ExchangeFixture.TEST_USD_KRW;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ExchangeAcceptanceTest extends AbstractAcceptanceTest {

    private static final String BASE_EXCHANGE_URL = "/exchange";

    @Test
    @DisplayName("환율정보를 전달해준다")
    void retrieveExchange_test() {
        RetrieveExchangeResponseDto response = webTestClient.get().uri(BASE_EXCHANGE_URL + "?source=USD&destination=KRW")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(RetrieveExchangeResponseDto.class)
                .returnResult().getResponseBody();

        assertThat(response.getSource()).isEqualTo(USD.getName());
        assertThat(response.getQuote()).isNotNull();
    }

    @Test
    @DisplayName("수취금액을 계산하여 전달한다")
    void calculateRecipientAmount_test() {
        CalculateRecipientRequestDto request = CalculateRecipientRequestDto.builder()
                .exchangeRate(TEST_USD_KRW)
                .transferAmount(200)
                .build();

        CalculateRecipientResponseDto response = webTestClient.post().uri(BASE_EXCHANGE_URL + "/recipient/amount")
                .body(Mono.just(request), CalculateRecipientRequestDto.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(CalculateRecipientResponseDto.class)
                .returnResult().getResponseBody();

        assertThat(response.getRecipientAmount()).isNotNull();
    }
}
