package com.nhnacademy.coupon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.nhnacademy.exceptions.AmountTargetIsMinusException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CouponTest {
    Coupon coupon;

    @DisplayName("쿠폰 적용 테스팅(1000원)")
    @Test
    void apply_1000won_coupon () {
        coupon = Coupon.ONE_THOUSON;
        int balance = 1500;
        assertThat(coupon.discount(balance)).isEqualTo(500);
    }

    @DisplayName("금액이 음수면 AmountTargetIsMinusException 던짐")
    @Test
    void apply_balance_is_negative_number(){
        coupon = Coupon.ONE_THOUSON;
        int balance = -1500;
        assertThatThrownBy(() -> coupon.discount(balance))
            .isInstanceOf(AmountTargetIsMinusException.class)
            .hasMessageContaining("음수", "할인");
    }

    @DisplayName("천 원보다 작을 때 최종금액은 0원")
    @Test
    void apply_balance_is_under_thousand(){
        coupon = Coupon.ONE_THOUSON;
        int balance = 500;
        assertThat(coupon.discount(balance)).isEqualTo(0);
    }

}
