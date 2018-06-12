package com.acme.test01.isaaccameron.exceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        System.out.println(message);
    }
}
