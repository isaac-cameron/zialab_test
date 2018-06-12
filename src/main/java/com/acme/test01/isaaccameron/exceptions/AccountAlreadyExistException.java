package com.acme.test01.isaaccameron.exceptions;

public class AccountAlreadyExistException extends Exception {
    public AccountAlreadyExistException(String message){
        System.out.println(message);
    }
}
