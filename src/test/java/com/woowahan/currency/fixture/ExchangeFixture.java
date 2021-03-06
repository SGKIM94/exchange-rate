package com.woowahan.currency.fixture;

import com.woowahan.currency.dto.CurrencyResponseDto;
import com.woowahan.currency.dto.QuotesDto;

import static com.woowahan.currency.domain.Countries.USD;

public class ExchangeFixture {
    public static final double TEST_USD_KRW = 84.095497;

    private static final QuotesDto TEST_QUOTES_DTO = QuotesDto.builder()
            .USDKRW(TEST_USD_KRW)
            .USDJPY(0.123133)
            .USDPHP(2.192873)
            .build();

    public static final CurrencyResponseDto TEST_CURRENCY = CurrencyResponseDto.builder()
            .source(USD.getName())
            .success(true)
            .quotes(TEST_QUOTES_DTO)
            .build();

}
