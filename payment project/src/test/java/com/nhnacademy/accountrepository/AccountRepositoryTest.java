package com.nhnacademy.accountrepository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import com.nhnacademy.Account;
import com.nhnacademy.exceptions.AccountAccessFailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountRepositoryTest {
    AccountRepository repo;

    @BeforeEach
    void setUp() {
        repo = new AccountRepository();
    }

    @Test
    @DisplayName("계정이 없으면 예외를 발생시킨다.")
    void check_available_account() {
        int id = 0;
        assertThatThrownBy(() -> repo.getAccountById(id))
            .isInstanceOf(AccountAccessFailException.class)
            .hasMessageContaining("유효하지 않은 접근입니다.");
    }


}
