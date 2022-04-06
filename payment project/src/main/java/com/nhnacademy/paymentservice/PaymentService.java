package com.nhnacademy.paymentservice;


import com.nhnacademy.account.Account;
import com.nhnacademy.accountrepository.AccountRepository;
import com.nhnacademy.coupon.Coupon;
import com.nhnacademy.exceptions.AmountTargetIsMinusException;

public class PaymentService {
    private final AccountRepository repo;

    public PaymentService(AccountRepository repo) {
        this.repo = repo;
    }
    public void pay(int amount, int customerId) {
        if (amount < 0){
            throw new AmountTargetIsMinusException("결제 금액이 음수입니다.");
        }
        Account account = this.repo.getAccountById(customerId);
        Coupon coupon = account.getCoupon();
    }
}
