package com.nhnacademy.paymentservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nhnacademy.account.Account;
import com.nhnacademy.accountrepository.AccountRepository;
import com.nhnacademy.exceptions.AccountAccessFailException;
import com.nhnacademy.exceptions.AmountTargetIsMinusException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
    PaymentService service;
    AccountRepository repo;

    @BeforeEach
    void setUp() {
        repo = mock(AccountRepository.class);
        service = new PaymentService(repo);
    }

    @Test
    void pay_amount_is_minus() {
        int amount = -1000;
        int accountId  = 1;
       assertThatThrownBy(() -> service
           .pay(amount,accountId))
           .isInstanceOf(AmountTargetIsMinusException.class)
           .hasMessageContaining("결제 금액","음수");
    }

    @Test
    @DisplayName("customer id로 account정보를 가져온다")
    void get_account_by_customer_id(){
        int id = 0;
        Account account = new Account(id);
        when(repo.getAccountById(id)).thenReturn(account);
        // repo.getAccountById(id)를 호출하면 account를 리턴한다.
        service.pay(500,id);
        verify(repo).getAccountById(id);
        // 검증한다. repo를, getAccountById(id);를 호출했니?
    }
}
