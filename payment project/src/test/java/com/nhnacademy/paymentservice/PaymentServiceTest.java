package com.nhnacademy.paymentservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.account.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {
    PaymentService service;

    @BeforeEach
    void setUp() {
        service = new PaymentService();

    }
    @DisplayName("pay에 대한 결과를 true로 해줌.")
    @Test
    void pay() {
        long amount = 10_000;
        long customerId = 1231231;
        assertThat(service.pay(amount,customerId)).isTrue();
    }
    @DisplayName("")
    @Test
    void findByCustomerId() {
        
    }

}