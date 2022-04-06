package com.nhnacademy.accountrepository;

import com.nhnacademy.account.Account;
import com.nhnacademy.exceptions.AccountAccessFailException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AccountRepository {
    private Map<Integer, Account> accounts = new HashMap<>();

    public Account getAccountById(int id) {
        Account foundAccount = accounts.get(id);
        if(Objects.isNull(foundAccount)){
            throw new AccountAccessFailException("유효하지 않은 접근입니다.");
        }
        return foundAccount;
    }
}
