package com.woowahan.currency.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class QuotesDto {
    private String USDKRW;
    private String USDJPY;
    private String USDPHP;

    public QuotesDto(String USDKRW, String USDJPY, String USDPHP) {
        this.USDKRW = USDKRW;
        this.USDJPY = USDJPY;
        this.USDPHP = USDPHP;
    }

    public String getUSDKRW() {
        return USDKRW;
    }

    public String getUSDJPY() {
        return USDJPY;
    }

    public String getUSDPHP() {
        return USDPHP;
    }
}
