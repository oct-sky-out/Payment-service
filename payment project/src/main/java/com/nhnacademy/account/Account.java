package com.nhnacademy.account;

import com.nhnacademy.coupon.Coupon;
import com.nhnacademy.exceptions.CouponIsEmptyException;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final List<Coupon> coupons = new ArrayList<>();
    private int customerId;
    private int balance;

    public Account(int customerId, int balance) {
        this.customerId = customerId;
        this.balance = balance;

        coupons.add(Coupon.ONE_THOUSON);
        coupons.add(Coupon.TEN);
        coupons.add(Coupon.TWENTY);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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
