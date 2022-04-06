package com.nhnacademy.paymentservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nhnacademy.account.Account;
import com.nhnacademy.accountrepository.AccountRepository;
import com.nhnacademy.calculator.Calculator;
import com.nhnacademy.coupon.Coupon;
import com.nhnacademy.exceptions.AmountTargetIsMinusException;
import com.nhnacademy.exceptions.CouponIsEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
    PaymentService service;
    AccountRepository repo;
    Calculator calculator;

    @BeforeEach
    void setUp() {
        repo = mock(AccountRepository.class);
        service = new PaymentService(repo);
        calculator = new Calculator();
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
        service.pay(500, id);
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
        assertThat(account.getCouponCount() > 0).isTrue();

        verify(repo).getAccountById(id);
    }

    @Test
    @DisplayName("사용자의 쿠폰을 1장을 가져오는데, 반드시 1000원이 뽑히는가?")
    void coupon_is_1000_coupon(){
        int id = 0;
        Account account = new Account(id);
        when(repo.getAccountById(id)).thenReturn(account);
        service.pay(500, id);
        assertThat(account.getCouponCount()).isEqualTo(2);
        verify(repo).getAccountById(id);
        // Account를 뽑아오고, 사이즈가 0 이상이면 쿠폰을 1번 가져오고 1000원 할인 쿠폰인가?.

    }
    @Test
    @DisplayName("사용자의 쿠폰을 2장을 가져오는데, 2번째 쿠폰은 반드시 10%쿠폰이 뽑히는가?")
    void coupon_is_10percent_coupon(){
        int id = 0;
        Account account = new Account(id);
        when(repo.getAccountById(id)).thenReturn(account);
        service.pay(500, id);
        Coupon coupon = account.getCoupon();
        assertThat(account.getCouponCount()).isEqualTo(1);
        assertThat(coupon).isEqualTo(Coupon.TEN);
        verify(repo).getAccountById(id);
        // Account를 뽑아오고, 사이즈가 0 이상이면 쿠폰을 3번 가져온다.

    }
    @Test
    @DisplayName("사용자의 쿠폰을 3장을 가져오는데, 3번쨰는 반드시 20%쿠폰이 뽑히는가?")
    void coupon_is_20percent_coupon(){
        int id = 0 ;
        Account account = new Account(id);
        when(repo.getAccountById(id)).thenReturn(account);
        service.pay(500,id);
        account.getCoupon();
        Coupon coupon = account.getCoupon();
        assertThat(account.getCouponCount()).isEqualTo(0);
        assertThat(coupon).isEqualTo(Coupon.TWENTY);
        verify(repo).getAccountById(id);
    }

    @Test
    @DisplayName("사용자의 쿠폰을 4번 뽑는데, 4번째는 예외를 던지는가?")
    void throw_coupon_is_not_found_exception(){
        // Account의 쿠폰을 4번 뽑으면, 예외를 발생.
        int id = 0;
        Account account = new Account(id);
        when(repo.getAccountById(id)).thenReturn(account);
        service.pay(500,id);
        account.getCoupon();
        account.getCoupon();
        assertThatThrownBy(() -> account.getCoupon())
            .isInstanceOf(CouponIsEmptyException.class)
            .hasMessageContaining("쿠폰","0개");
        verify(repo).getAccountById(id);
    }

    @Test
    @DisplayName("쿠폰 적용한 금액 산출하기 (실금액 산출)")
    void applied_coupon_and_get_balance(){
        int id = 0;
        int amount = 1000;
        Account account = new Account(id);
        when(repo.getAccountById(id)).thenReturn(account);
        when(calculator.applyCoupon(amount, Coupon.ONE_THOUSON)).thenReturn(0);
        service.pay(amount, id);

        verify(calculator).applyCoupon(amount, Coupon.ONE_THOUSON);
        // amount는 결제 대상금액 여기서는 500원
    }
}
