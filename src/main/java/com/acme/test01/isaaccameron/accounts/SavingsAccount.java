package com.acme.test01.isaaccameron.accounts;

import com.acme.test01.isaaccameron.enums.AccountType;

public class SavingsAccount<T> extends Account {
    private static AccountType type = AccountType.SAVINGS;
    private Long accountId;
    private String clientName;
    private int accountBalance;
    private static int overdraftLimit = 0;

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
    public String getClientName() {
        return clientName;
    }

    @Override
    public int getAccountBalance() {
        return accountBalance;
    }

    @Override
    public void setAccountBalance(int amount) {
        this.accountBalance = amount;
    }

    @Override
    public int getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public int getAvailableBalance() {
        return (overdraftLimit + accountBalance);
    }

    public static void setType(AccountType type) {
        SavingsAccount.type = type;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setOverdraftLimit(int overdraftLimit) {

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
