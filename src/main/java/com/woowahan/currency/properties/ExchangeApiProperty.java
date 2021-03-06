package com.woowahan.currency.properties;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("exchange-api")
@Setter
public class ExchangeApiProperty {
    private String domain;
    private String accesskey;
    private String url;


    public String getUrl() {
        return domain + "?access_key=" + accesskey;
    }

    public String getDomain() {
        return domain;
    }

    public String getAccesskey() {
        return accesskey;
    }
}
