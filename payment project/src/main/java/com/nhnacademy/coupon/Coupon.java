package com.nhnacademy.coupon;

import com.nhnacademy.exceptions.AmountTargetIsMinusException;

public enum Coupon implements Discountable  {
    ONE_THOUSON(1000, 0){
        @Override
        public int discount(int balance) {
            if(balance < 0){
                throw new AmountTargetIsMinusException("가격이 음수면 할인이 불가능합니다.");
            }
            if(balance < 1000){
                return 0;
            }
            return balance - this.amt;
        }
    },
    TEN(0, 0.1) {
        @Override
        public int discount(int balance) {
            return 0;
        }
    },

    TWENTY(0, 0.2){
        @Override
        public int discount(int balance){
            return 0;
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
