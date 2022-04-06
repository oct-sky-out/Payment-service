package com.nhnacademy.accountrepository;

import com.nhnacademy.account.Account;
import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    private Map<Long, Account> accountRepo = new HashMap<>();
    private Long accountKey = 1;

    public void addAccount(Account account){
        this.accountRepo.put();
    }

    public Account getAccountByCustomerId(long customerId){
        return accountRepo.get(customerId);
    }
}
