package com.nhnacademy.account;

import com.nhnacademy.coupon.Coupon;
import com.nhnacademy.point.Point;

public class Account {
    private final String email;
    private final String phoneNumber;
    private final int amount;
    private final Coupon coupon;
    private final Point point;

    public Account(String email, String phoneNumber, int amount) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.coupon = null;
        this.point = null;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAmount() {
        return amount;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public Point getPoint() {
        return point;
    }
}
