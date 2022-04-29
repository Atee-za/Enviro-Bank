package com.eviro.assessment.grad001.athenkosizono.Domain.Database;

import com.eviro.assessment.grad001.athenkosizono.Domain.*;
import java.util.HashSet;
import java.util.Set;

public class SystemDB {

    private static SystemDB systemDB = null;
    private Set<Account> accounts;

    private SystemDB(){
        accounts = new HashSet<>();
    }

    public static SystemDB getSystemDB(){
        if(systemDB == null){
            systemDB = new SystemDB();
        }
        return systemDB;
    }

    public void addAll(Set<Account> newAccounts){
        accounts.addAll(newAccounts);
    }

    public void add(Account account){
        accounts.add(account);
    }

    public boolean remove(Account account){
        return this.accounts.remove(account);
    }

    public Account findByAccountNum(String accountNum){
        return accounts.stream().filter(a -> a.getAccountNum().equals(accountNum)).findAny().orElse(null);
    }

    public Set<Account> getAll(){
        return accounts;
    }

}
