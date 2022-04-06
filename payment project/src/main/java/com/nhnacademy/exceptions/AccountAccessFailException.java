package com.nhnacademy.exceptions;

public class AccountAccessFailException extends RuntimeException {
    public AccountAccessFailException(String message) {
        super(message);
    }
}
