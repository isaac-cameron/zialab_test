package com.acme.test01.isaaccameron.main;

public abstract class Account {
    abstract Account getAccount(Long accountNumber);
    abstract void createAccount(Long accountNumber, Long openingBalance);
}
