package com.nhnacademy.exceptions;

public class AmountTargetIsMinusException extends IllegalArgumentException{
    public AmountTargetIsMinusException(String message) {
        super(message);
    }
}
