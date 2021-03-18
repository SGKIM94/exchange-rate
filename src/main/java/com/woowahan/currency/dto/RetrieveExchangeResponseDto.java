package com.woowahan.currency.dto;

import com.woowahan.currency.domain.Countries;
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

    public static RetrieveExchangeResponseDto toDto(CurrencyResponseDto currency, Countries source, Countries destination) {
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
