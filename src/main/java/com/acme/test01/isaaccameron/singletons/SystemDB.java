package com.acme.test01.isaaccameron.singletons;

import com.acme.test01.isaaccameron.accounts.Account;
import com.acme.test01.isaaccameron.exceptions.AccountNotFoundException;

import java.util.HashMap;

public class SystemDB {

    private static SystemDB ourInstance;
    protected HashMap<Long, Account> accounts = new HashMap<Long, Account>();

    private SystemDB() {
    }

    public static SystemDB getInstance() {
        if (ourInstance == null){
            ourInstance = new SystemDB();
        }
        return ourInstance;
    }

    public void saveAccount(Account account) {
        System.out.println("Saving Account: "+account.toString());
        System.out.println(account.toString());
        accounts.put(account.getAccountId(), account);
    }

    public Account getAccount(Long accountId) throws AccountNotFoundException {
        if (!accounts.containsKey(accountId)) {
            throw new AccountNotFoundException("Account not found");
        } else {
            return accounts.get(accountId);
        }
    }

    @Override
    public String toString(){
        String db = new String();
        for (Account account: accounts.values()) db += (account.toString()+"\n");
        return db;
    }
}
