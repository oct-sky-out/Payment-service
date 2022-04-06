package com.nhnacademy.paymentservice;


import com.nhnacademy.account.Account;
import com.nhnacademy.accountrepository.AccountRepository;
import com.nhnacademy.coupon.Coupon;
import com.nhnacademy.exceptions.AmountTargetIsMinusException;
import com.nhnacademy.exceptions.NotEnoughMoneyException;

public class PaymentService {
    private final AccountRepository repo;

    public PaymentService(AccountRepository repo) {
        this.repo = repo;
    }

    public Account pay(int amount, int customerId) {
        if (amount < 0){
            throw new AmountTargetIsMinusException("결제 금액이 음수입니다.");
        }
        Account account = this.repo.getAccountById(customerId);
        Coupon coupon = account.getCoupon();
        int discountedAmt = coupon.discount(amount); // 쿠폰 적용한 가격
        int resultAmt = account.getBalance() - discountedAmt;
        if(resultAmt<0){
            throw new NotEnoughMoneyException("잔액이 부족합니다.");
        }
        account.setBalance(resultAmt); // 실 결제 금액 후 사용자의 잔액 설정

        return account;
    }
}
