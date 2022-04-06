package com.nhnacademy.accountrepository;

import com.nhnacademy.account.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;

class AccountRepositoryTest {
    private AccountRepository repo;

    @BeforeEach
    void setUp() {
        repo = new AccountRepository();
    }

    @Test
    void addAccount() {
        String email = "abc@nhn.com";
        String phoneNumber = "010-1111-2222";
        int amount = 10_000;
        Account account = new Account(email, phoneNumber, amount);

        repo.addAccount(account);
        Account num1Account = repo.getAccountByCustomerId(1);
        assertThat(num1Account.getEmail()).isEqualTo(email);
        assertThat(num1Account.getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(num1Account.getAmount()).isEqualTo(amount);
    }
}
