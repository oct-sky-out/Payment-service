package com.nhnacademy.paymentservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nhnacademy.account.Account;
import com.nhnacademy.accountrepository.AccountRepository;
import com.nhnacademy.coupon.Coupon;
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

    @Test
    @DisplayName("사용자의 쿠폰을 가져올 수 있는가?")
    void get_account_coupon(){
        int id = 0;
        Account account = new Account(id);
        when(repo.getAccountById(id)).thenReturn(account);
        service.pay(500, id);

        // Account를 뽑아오고, 사이즈가 0 이상인가?
        assertThat(account.getCouponCount()).isEqualTo(3);

        verify(repo).getAccountById(id);
    }

    @Test
    @DisplayName("사용자의 쿠폰을 1장을 가져오는데, 반드시 1000원이 뽑히는가?")
    void coupon_is_1000_coupon(){
        // Account를 뽑아오고, 사이즈가 0 이상이면 쿠폰을 1번 가져오고 1000원 할인 쿠폰인가?.

    }
    @Test
    @DisplayName("사용자의 쿠폰을 2장을 가져오는데, 2번째 쿠폰은 반드시 10%쿠폰이 뽑히는가?")
    void coupon_is_10percent_coupon(){
        // Account를 뽑아오고, 사이즈가 0 이상이면 쿠폰을 3번 가져온다.

    }
    @Test
    @DisplayName("사용자의 쿠폰을 3장을 가져오는데, 3번쨰는 반드시 20%쿠폰이 뽑히는가?")
    void coupon_is_20percent_coupon(){


    }

    @Test
    @DisplayName("사용자의 쿠폰을 4번 뽑는데, 4번째는 예외를 던지는가?")
    void coupon_is_20percent_coupon(){
        // Account를 뽑아오고, 사이즈가 0 이상이면 쿠폰을 4번 가져온다 예외 발생.

    }

}
