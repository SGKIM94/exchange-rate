package com.woowahan.currency.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.woowahan.currency.domain.Countries;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class CurrencyResponseDto implements ClientResponseDto {
    private boolean success;
    private String source;
    private Map<String, Double> quotes;

    @Builder
    public CurrencyResponseDto(boolean success, String source, Map<String, Double> quotes) {
        this.success = success;
        this.source = source;
        this.quotes = quotes;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getSource() {
        return source;
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }

    @JsonIgnore
    Double getQuote(Countries source, Countries destination) {
        return quotes.get(source.getName() + destination.getName());
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
