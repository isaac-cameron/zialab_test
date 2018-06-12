package com.acme.test01.isaaccameron.services;

import com.acme.test01.isaaccameron.accounts.Account;
import com.acme.test01.isaaccameron.singletons.SystemDB;
import com.acme.test01.isaaccameron.exceptions.*;

public class AccountService implements com.acme.test01.isaaccameron.interfaces.AccountService {
    @Override
    public void openSavingsAccount(Long accountId, Long amountToDeposit) {

    }

    @Override
    public void openCurrentAccount(Long accountId) {

    }

    @Override
    public void withdraw(Long accountId, int amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException {
     
    }

    @Override
    public void deposit(Long accountId, int amountToDeposit) throws AccountNotFoundException {

    }

    private SystemDB getSystemDB(){
        return SystemDB.getInstance();
    }
}
