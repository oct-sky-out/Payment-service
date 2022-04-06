package com.nhnacademy.account;

import com.nhnacademy.coupon.Coupon;
import com.nhnacademy.exceptions.CouponIsEmptyException;
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
        if(this.getCouponCount() == 0){
            throw new CouponIsEmptyException("쿠폰이 0개입니다.");
        }
        return coupons.remove(0);
    }

    public int getCouponCount(){
        return this.coupons.size();
    }


}
