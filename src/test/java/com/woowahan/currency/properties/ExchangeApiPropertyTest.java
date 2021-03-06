package com.woowahan.currency.properties;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class ExchangeApiPropertyTest {

    @Autowired
    private ExchangeApiProperty property;

    @Test
    @DisplayName("환율정보를 조회하기 위한 API의 URL 을 가져온다")
    void get_exchange_url_test() {
        String url = property.getUrl();

        assertThat(url).isEqualTo("http://www.apilayer.net/api/live?access_key=ee50cd7cc73c9b7a7bb3d9617cfb6b9c");
    }
}
