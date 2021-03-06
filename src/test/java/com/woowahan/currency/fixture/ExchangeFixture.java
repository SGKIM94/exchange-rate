package com.woowahan.currency.fixture;

import com.woowahan.currency.dto.CurrencyResponseDto;

import java.util.HashMap;
import java.util.Map;

import static com.woowahan.currency.domain.Countries.USD;

public class ExchangeFixture {
    public static final double TEST_USD_KRW = 84.123497;
    public static final String TEST_FORMATTED_USD_KRW = "84.12";
    public static final String USDKRW_KEY = "USDKRW";
    public static final String USDJPY_KEY = "USDJPY";
    public static final String USDPHP_KEY = "USDPHP";

    public static final CurrencyResponseDto TEST_CURRENCY = CurrencyResponseDto.builder()
            .source(USD.getName())
            .success(true)
            .quotes(getTestQuotesDto())
            .build();

    private static Map<String, Double> getTestQuotesDto() {
        Map<String, Double> quotes = new HashMap<>();
        quotes.put(USDKRW_KEY, TEST_USD_KRW);
        quotes.put(USDJPY_KEY, 2.0123012);
        quotes.put(USDPHP_KEY, 0.1283712);

        return quotes;
    }
}
