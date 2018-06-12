package com.acme.test01.isaaccameron.interfaces;

import com.acme.test01.isaaccameron.accounts.Account;
import com.acme.test01.isaaccameron.exceptions.*;

public interface AccountService {
    public Account openSavingsAccount(Long accountId, int amountToDeposit) throws SavingsBalanceMinimumException;
    public Account openCurrentAccount(Long accountId);
    public void withdraw(Long accountId, int amountToWithdraw)
            throws AccountNotFoundException, WithdrawalAmountTooLargeException;
    public void deposit(Long accountId, int amountToDeposit)
            throws AccountNotFoundException, CurrentMaximumException;
    public void saveAccount(Account account);
    public void showDB();
}
