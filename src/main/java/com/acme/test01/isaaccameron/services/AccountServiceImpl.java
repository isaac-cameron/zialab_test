package com.acme.test01.isaaccameron.services;

import com.acme.test01.isaaccameron.accounts.Account;
import com.acme.test01.isaaccameron.accounts.CurrentAccount;
import com.acme.test01.isaaccameron.accounts.SavingsAccount;
import com.acme.test01.isaaccameron.enums.AccountType;
import com.acme.test01.isaaccameron.interfaces.AccountService;
import com.acme.test01.isaaccameron.singletons.SystemDB;
import com.acme.test01.isaaccameron.exceptions.*;

public class AccountServiceImpl implements AccountService {

    protected static int SAVINGS_MIN = 1000;
    protected static int CURRENT_MAX = 100000;
    static SystemDB systemDB = SystemDB.getInstance();

    @Override
    public Account openSavingsAccount(Long accountId, int amountToDeposit) throws SavingsBalanceMinimumException{
        System.out.println("Creating Savings account AccountID: "+accountId+", deposit amount: R"+amountToDeposit);
        if (amountToDeposit < SAVINGS_MIN) {
            throw new SavingsBalanceMinimumException("Savings account balance cannot be less then R" + SAVINGS_MIN);
        }

        SavingsAccount account = new SavingsAccount();
        account.setAccountBalance(amountToDeposit);
        account.setAccountId(accountId);
        systemDB.saveAccount(account);
        return account;
    }

    @Override
    public Account openCurrentAccount(Long accountId) {
        System.out.println("Creating Savings Current AccountID: "+accountId);
        CurrentAccount account = new CurrentAccount();
        account.setAccountId(accountId);
        systemDB.saveAccount(account);
        return account;
    }

    @Override
    public void withdraw(Long accountId, int amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException {
        System.out.println("Withdraw R"+amountToWithdraw+" from AccountID: "+accountId);
        Account account = systemDB.getAccount(accountId);
        if (amountToWithdraw > account.getAvailableBalance()) {
            throw new WithdrawalAmountTooLargeException("Withdrawal amount too large");
        } else {
            account.setAccountBalance(account.getAccountBalance() - amountToWithdraw);
            systemDB.saveAccount(account);
        }
    }

    @Override
    public void deposit(Long accountId, int amountToDeposit) throws AccountNotFoundException, CurrentMaximumException {
        System.out.println("Deposit R"+amountToDeposit+" into AccountID: "+accountId);
        Account account = systemDB.getAccount(accountId);
        if ((account.getType() == AccountType.CURRENT) &&
                (account.getAccountBalance() + amountToDeposit > CURRENT_MAX)){
            throw new CurrentMaximumException("Account balance too big after deposit");
        }
        account.setAccountBalance(account.getAccountBalance() + amountToDeposit);
        systemDB.saveAccount(account);
    }

    @Override
    public void saveAccount(Account account) {
        systemDB.saveAccount(account);
    }

    @Override
    public void showDB() {
        System.out.println(systemDB.toString());
    }

}
