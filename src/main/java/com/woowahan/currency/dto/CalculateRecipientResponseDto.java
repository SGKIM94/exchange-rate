package com.woowahan.currency.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CalculateRecipientResponseDto {
    private double recipientAmount;

    @Builder
    public CalculateRecipientResponseDto(double recipientAmount) {
        this.recipientAmount = recipientAmount;
    }

    public static CalculateRecipientResponseDto toDto(double recipientAmount) {
        return CalculateRecipientResponseDto.builder()
                .recipientAmount(recipientAmount)
                .build();
    }

    public double getRecipientAmount() {
        return recipientAmount;
    }
}
