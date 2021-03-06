package com.woowahan.currency.dto;

import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Objects;

@NoArgsConstructor
public class FormattedQuote {
    private static final int DELIMITER_INTERVAL = 3;

    private String value;

    public FormattedQuote(double value) {
        this.value = formatDouble(value);
    }

    public String getValue() {
        return value;
    }

    private String formatDouble(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(DELIMITER_INTERVAL);
        return decimalFormat.format(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormattedQuote that = (FormattedQuote) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
