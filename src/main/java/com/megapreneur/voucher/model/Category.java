package com.megapreneur.voucher.model;

import lombok.Setter;


public enum Category {
    Platinum("100-500"),
    Silver("501-1000"),
    Gold("1001-5000"),
    Diamond("5001-10000");

    private final String range;
    Category(String range) {
        this.range = range;
    }

    public String getRange() {
        return range;
    }

}
