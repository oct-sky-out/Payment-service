package com.nhnacademy.exceptions;

public class CouponIsEmptyException extends RuntimeException{
    public CouponIsEmptyException(String s) {
        super(s);
    }
}