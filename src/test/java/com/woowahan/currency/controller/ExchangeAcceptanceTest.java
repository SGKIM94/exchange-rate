package com.woowahan.currency.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExchangeAcceptanceTest extends AbstractAcceptanceTest {

    private static final String BASE_EXCHANGE_URL = "/exchange";

    @Test
    @DisplayName("환율정보를 전달해준다")
    void retrieveExchange_test() {
        webTestClient.get().uri(BASE_EXCHANGE_URL)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody();
    }

    @Test
    @DisplayName("수취금액을 계산하여 전달한다")
    void calculateRecipientAmount_test() {
        webTestClient.post().uri(BASE_EXCHANGE_URL + "/recipient/amount")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody();
    }
}
