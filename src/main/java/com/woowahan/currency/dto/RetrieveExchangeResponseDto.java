package com.woowahan.currency.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RetrieveExchangeResponseDto {
    private String source;
    private FormattedQuote quote;

    @Builder
    public RetrieveExchangeResponseDto(String source, double quote) {
        this.source = source;
        this.quote = new FormattedQuote(quote);
    }

    public static RetrieveExchangeResponseDto toDto(CurrencyResponseDto currency, String source, String destination) {
        return RetrieveExchangeResponseDto.builder()
                .source(currency.getSource())
                .quote(currency.getQuote(source, destination))
                .build();
    }

    public String getSource() {
        return source;
    }

    public FormattedQuote getQuote() {
        return quote;
    }
}
