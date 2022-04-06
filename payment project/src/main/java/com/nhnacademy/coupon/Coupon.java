package com.nhnacademy.coupon;

public class Coupon {
    private final String couponName;
    private final float rate; // 할인율
    private final int amt;  // 할인 금액

    public Coupon(String couponName, float rate, int amt) {
        this.couponName = couponName;
        this.rate = rate;
        this.amt = amt;
    }

    public static Coupon rateCoupon(String couponName, float rate){
        return new Coupon(couponName, rate, 0);
    }

    public static Coupon amtCoupon(String couponName, int amt){
        return new Coupon(couponName, 0F, amt);
    }

}
