package com.nhnacademy.coupon;

public enum Coupon {
    ONE_THOUSON(1000, 0),
    TEN(0, 0.1),
    TWENTY(0, 0.2)
    ;

    private final int amt;
    private final double rate;

    Coupon(int amt, double rate){
        this.amt = amt;
        this.rate = rate;
    }
}
