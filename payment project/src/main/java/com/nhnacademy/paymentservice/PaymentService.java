package com.nhnacademy.paymentservice;


import com.nhnacademy.exceptions.AmountTargetIsMinusException;
import com.nhnacademy.receipt.Receipt;

public class PaymentService {

    public void pay(int amount, int customerId) {
        if (amount < 0){
            throw new AmountTargetIsMinusException("결제 금액이 음수입니다.");
        }
    }
}
