package com.acme.test01.isaaccameron.accounts;

import com.acme.test01.isaaccameron.enums.AccountType;

public class CurrentAccount extends Account {
    private static AccountType type = AccountType.CURRENT;
    private Long accountId;
    private String clientName;
    private int accountBalance;
    private int overdraftLimit;

    @Override
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public AccountType getType() {
        return type;
    }

    @Override
    public int getAvailableBalance() {
        return (overdraftLimit + accountBalance);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    @Override
    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void setOverdraftLimit(int overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountId=" + accountId +
                ", accountType='" + type + '\'' +
                ", clientName='" + clientName + '\'' +
                ", accountBalance=" + accountBalance +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}
