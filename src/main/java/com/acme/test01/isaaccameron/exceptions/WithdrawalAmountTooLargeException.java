package com.acme.test01.isaaccameron.exceptions;

public class WithdrawalAmountTooLargeException extends Exception {
    public WithdrawalAmountTooLargeException(String message) {
        System.out.println(message);
    }
}
