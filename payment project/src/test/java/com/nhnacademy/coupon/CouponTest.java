package com.nhnacademy.coupon;

import static org.assertj.core.api.Assertions.assertThat;

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

}
