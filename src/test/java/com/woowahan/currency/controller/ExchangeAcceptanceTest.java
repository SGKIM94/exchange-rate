package com.woowahan.currency.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExchangeAcceptanceTest extends AbstractAcceptanceTest {

    @Test
    @DisplayName("환율 정보를 전달해준다.")
    void retrieveExchange() {
        webTestClient.get().uri("/exchange")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody();
    }
}
