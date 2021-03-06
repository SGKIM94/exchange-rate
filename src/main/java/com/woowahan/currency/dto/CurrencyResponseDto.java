package com.woowahan.currency.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CurrencyResponseDto implements ClientResponseDto {
    private boolean success;
    private String source;
    private QuotesDto quotes;

    @Builder
    public CurrencyResponseDto(boolean success, String source, QuotesDto quotes) {
        this.success = success;
        this.source = source;
        this.quotes = quotes;
    }

    @Override
    public String toString() {
        return "CurrencyResponseDto{" +
                "success=" + success +
                ", source='" + source + '\'' +
                ", quotes=" + quotes +
                '}';
    }
}
