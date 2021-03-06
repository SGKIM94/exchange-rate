package com.woowahan.currency.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CalculateRecipientResponseDto {
    private String recipientAmount;

    @Builder
    public CalculateRecipientResponseDto(String recipientAmount) {
        this.recipientAmount = recipientAmount;
    }

    public String getRecipientAmount() {
        return recipientAmount;
    }
}
