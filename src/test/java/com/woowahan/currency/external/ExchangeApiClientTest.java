package com.woowahan.currency.external;

import com.woowahan.currency.dto.CurrencyResponseDto;
import com.woowahan.currency.properties.ExchangeApiProperty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.woowahan.currency.domain.Countries.USD;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ExchangeApiClientTest {

    @Autowired
    private ExchangeApiClient exchangeApiClient;

    @Autowired
    private ExchangeApiProperty property;

    @Test
    void retrieve_test() {
        CurrencyResponseDto response = exchangeApiClient.retrieve(property.getUrl());

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getSource()).isEqualTo(USD.getName());
    }
}
