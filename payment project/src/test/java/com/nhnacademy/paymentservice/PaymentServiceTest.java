package com.nhnacademy.paymentservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import com.nhnacademy.account.Account;
import com.nhnacademy.exceptions.AccountAccessFailException;
import com.nhnacademy.exceptions.AmountTargetIsMinusException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
    PaymentService service;

    @BeforeEach
    void setUp() {
        service = new PaymentService();
    }

    @Test
    void pay_amount_is_minus() {
        int amount = -1000;
        int accountId  = 1;
       assertThatThrownBy(()->service
           .pay(amount,accountId))
           .isInstanceOf(AmountTargetIsMinusException.class)
           .hasMessageContaining("결제 금액","음수");
    }
}
