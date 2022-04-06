package com.nhnacademy.account;

import com.nhnacademy.coupon.Coupon;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private int customerId;
    private final List<Coupon> coupons = new ArrayList<>();

    public Account(int customerId) {
        this.customerId = customerId;

        coupons.add(Coupon.ONE_THOUSON);
        coupons.add(Coupon.TEN);
        coupons.add(Coupon.TWENTY);
    }

    public int getCustomerId() {
        return customerId;
    }

    public Coupon getCoupon() {
        return coupons.remove(0);
    }

    public int getCouponCount(){
        return this.coupons.size();
    }


}
