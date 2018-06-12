package com.acme.test01.isaaccameron.accounts;

import com.acme.test01.isaaccameron.enums.AccountType;

public abstract class Account {
    public abstract AccountType getType();
    public abstract String getClientName();
    public abstract int getAccountBalance();
    public abstract void setAccountBalance(int amount);
    public abstract int getOverdraftLimit();
    public abstract void setOverdraftLimit(int overdraftLimit);
    public abstract int getAvailableBalance();
    public abstract Long getAccountId();
}
