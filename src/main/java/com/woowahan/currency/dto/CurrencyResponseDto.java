package com.woowahan.currency.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CurrencyResponseDto implements ClientResponseDto {
    private boolean success;
    private String source;
    private QuotesDto quotesDto;

    public CurrencyResponseDto(boolean success, String source, QuotesDto quotesDto) {
        this.success = success;
        this.source = source;
        this.quotesDto = quotesDto;
    }

    @Override
    public String toString() {
        return "CurrencyResponseDto{" +
                "success=" + success +
                ", source='" + source + '\'' +
                ", quotesDto=" + quotesDto +
                '}';
    }
}
