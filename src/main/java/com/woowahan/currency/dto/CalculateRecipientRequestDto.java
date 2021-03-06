package com.woowahan.currency.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
public class CalculateRecipientRequestDto {
    @NotEmpty(message = "환율이 존재하지 않습니다")
    private double exchangeRate;

    @Max(value = 10000, message = "송금액이 바르지 않습니다")
    @Min(value = 0, message = "송금액이 바르지 않습니다")
    private int transferAmount;

    @Builder
    public CalculateRecipientRequestDto(double exchangeRate, int transferAmount) {
        this.exchangeRate = exchangeRate;
        this.transferAmount = transferAmount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double getTransferAmount() {
        return transferAmount;
    }
}
