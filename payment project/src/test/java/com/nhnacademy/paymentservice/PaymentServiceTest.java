package com.nhnacademy.paymentservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.nhnacademy.account.Account;
import com.nhnacademy.receipt.Receipt;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
    PaymentService service;

    @Test
    void pay(){
        int amount = 1000;
        Receipt receipt = mock(Receipt.class);
        Account account = mock(Account.class);
        assertThat(service.pay(amount,account.getCustomerId())).isEqualTo(receipt);
    }

}
