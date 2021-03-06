package com.woowahan.currency.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CalculateRecipientResponseDto {
    private FormattedQuote recipientAmount;

    @Builder
    public CalculateRecipientResponseDto(double recipientAmount) {
        this.recipientAmount = new FormattedQuote(recipientAmount);
    }

    public static CalculateRecipientResponseDto toDto(double recipientAmount) {
        return CalculateRecipientResponseDto.builder()
                .recipientAmount(recipientAmount)
                .build();
    }

    public FormattedQuote getRecipientAmount() {
        return recipientAmount;
    }
}
