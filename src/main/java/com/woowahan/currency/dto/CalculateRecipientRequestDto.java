package com.woowahan.currency.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CalculateRecipientRequestDto {
    private String recipientCountry;
    private double transferAmount;

    @Builder
    public CalculateRecipientRequestDto(String recipientCountry, double transferAmount) {
        this.recipientCountry = recipientCountry;
        this.transferAmount = transferAmount;
    }

    public String getRecipientCountry() {
        return recipientCountry;
    }

    public double getTransferAmount() {
        return transferAmount;
    }
}
