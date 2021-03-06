package com.woowahan.currency.external;

import com.woowahan.currency.dto.CurrencyResponseDto;
import com.woowahan.currency.dto.QuotesDto;
import com.woowahan.currency.properties.ExchangeApiProperty;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("환율정보를 currencycylayer를 통해 가져온다")
    void retrieve_test() {
        CurrencyResponseDto response = exchangeApiClient.retrieve(property.getUrl());

        QuotesDto quotes = response.getQuotes();

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getSource()).isEqualTo(USD.getName());
        assertThat(quotes.getUSDJPY()).isNotNull();
        assertThat(quotes.getUSDKRW()).isNotNull();
        assertThat(quotes.getUSDPHP()).isNotNull();
    }
}
