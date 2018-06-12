package com.acme.test01.isaaccameron.services;

import com.acme.test01.isaaccameron.accounts.Account;
import com.acme.test01.isaaccameron.exceptions.AccountNotFoundException;
import com.acme.test01.isaaccameron.exceptions.CurrentMaximumException;
import com.acme.test01.isaaccameron.exceptions.SavingsBalanceMinimumException;
import com.acme.test01.isaaccameron.exceptions.WithdrawalAmountTooLargeException;
import com.acme.test01.isaaccameron.interfaces.AccountService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class AccountServiceImplTest {

    AccountService service = new AccountServiceImpl();

    @Before
    public void before() {
        System.out.println("============ DB Before Test ==============");
        service.showDB();
    }

    @After
    public void after() {
        System.out.println("============ DB After Test ==============");
        service.showDB();
    }

    @org.junit.Test
    public void openSavingsAccount() {

        Account account;
        try {
            account = service.openSavingsAccount(1L,2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            account = service.openSavingsAccount(2L,5000);
        } catch (SavingsBalanceMinimumException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void openCurrentAccount()  {
        Account account = service.openCurrentAccount(3L);
        account.setAccountBalance(1000);
        account.setOverdraftLimit(20000);
        service.saveAccount(account);

        account = service.openCurrentAccount(4L);
        account.setAccountBalance(5000);
        account.setOverdraftLimit(20000);
        service.saveAccount(account);
    }

    @org.junit.Test
    public void withdraw() {
        try {
            service.withdraw(1L, 20);
        } catch (AccountNotFoundException e) {
        } catch (WithdrawalAmountTooLargeException e) {
        }

        try {
            service.withdraw(1L, 22222);
        } catch (AccountNotFoundException e) {
        } catch (WithdrawalAmountTooLargeException e) {
        }
    }

    @org.junit.Test
    public void deposit() {
        try {
            service.deposit(3L, 1000000);
        } catch (AccountNotFoundException e) {
        } catch (CurrentMaximumException e) {
        }
    }
}