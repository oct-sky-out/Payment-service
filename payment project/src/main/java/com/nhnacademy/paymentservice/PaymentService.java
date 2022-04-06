package com.nhnacademy.paymentservice;


import com.nhnacademy.account.Account;
import com.nhnacademy.accountrepository.AccountRepository;
import com.nhnacademy.calculator.Calculator;
import com.nhnacademy.coupon.Coupon;
import com.nhnacademy.exceptions.AmountTargetIsMinusException;

public class PaymentService {
    private final AccountRepository repo;
    private final Calculator calculator;

    public PaymentService(AccountRepository repo, Calculator calculator) {
        this.repo = repo;
        this.calculator = calculator;
    }

    public void pay(int amount, int customerId) {
        if (amount < 0){
            throw new AmountTargetIsMinusException("결제 금액이 음수입니다.");
        }

        Account account = this.repo.getAccountById(customerId);
        Coupon coupon = account.getCoupon();
        int appliedAmount = calculator.applyCoupon(amount, coupon); // 쿠폰 적용 가격


    }
}
