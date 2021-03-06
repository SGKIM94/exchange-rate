package com.woowahan.currency.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class QuotesDto {
    private double USDKRW;
    private double USDJPY;
    private double USDPHP;

    @Builder
    public QuotesDto(double USDKRW, double USDJPY, double USDPHP) {
        this.USDKRW = USDKRW;
        this.USDJPY = USDJPY;
        this.USDPHP = USDPHP;
    }

    public double getUSDKRW() {
        return USDKRW;
    }

    public double getUSDJPY() {
        return USDJPY;
    }

    public double getUSDPHP() {
        return USDPHP;
    }
}
