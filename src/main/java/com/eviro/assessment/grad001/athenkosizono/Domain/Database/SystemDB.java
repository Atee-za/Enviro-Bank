package com.eviro.assessment.grad001.athenkosizono.Domain.Database;

import com.eviro.assessment.grad001.athenkosizono.Domain.*;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
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

    public void withdraw(String accountNum, BigDecimal amountToWithdraw) throws Exception {
        Account account = accounts.stream().filter(a -> a.getAccountNum().equals(accountNum)).findAny().orElse(null);
        if(account == null){
            throw new AccountNotFoundException("AccountNotFoundException");
        }
        else{
            if(account instanceof CurrentAccount){
                BigDecimal maxLimit = account.getBalance().add(((CurrentAccount) account).getOverdraft());
                if(amountToWithdraw.compareTo(maxLimit) > 0){
                    throw new Exception("WithdrawalAmountTooLargeException");
                }
                else{
                    accounts.remove(account);
                    account.setBalance(account.getBalance().subtract(amountToWithdraw));
                    accounts.add(account);
                    System.out.println("Successfully withdrawn...");
                    System.out.println(account);
                }
            }
            else if(account instanceof SavingsAccount){
                BigDecimal minLimit = account.getBalance().subtract(amountToWithdraw);
                if(minLimit.compareTo(BigDecimal.valueOf(1000)) < 0){
                    throw new Exception("WithdrawalAmountTooLargeException");
                }
                else{
                    accounts.remove(account);
                    account.setBalance(account.getBalance().subtract(amountToWithdraw));
                    accounts.add(account);
                    System.out.println("Successfully withdrawn...");
                    System.out.println(account);
                }
            }
        }
    }

    public void addAll(Set<Account> newAccounts){
        accounts.addAll(newAccounts);
    }

    public void add(Account account){
        accounts.add(account);
    }

    public Set<Account> getAll(){
        return accounts;
    }

}
