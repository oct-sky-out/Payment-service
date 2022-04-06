package com.nhnacademy.coupon;

public enum Coupon implements Discountable  {
    ONE_THOUSON(1000, 0){
        @Override
        public int discount(int balance) {
            return balance - this.amt;
        }

    },
    TEN(0, 0.1) {
        @Override
        public int discount(int balance) {
            return (int) (balance - this.rate);
        }
    },

    TWENTY(0, 0.2){
        @Override
        public int discount(int balance){
            return (int)(balance * this.rate);
        }
    }
    ;


    final int amt;
    final double rate;

    Coupon(int amt, double rate){
        this.amt = amt;
        this.rate = rate;
    }
}
