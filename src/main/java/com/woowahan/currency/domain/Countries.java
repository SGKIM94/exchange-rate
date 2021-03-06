package com.woowahan.currency.domain;

public enum Countries {
    KRW("KRW"), USD("USD"), JPY("JPY"), PHP("PHP");

    private String name;

    Countries(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
