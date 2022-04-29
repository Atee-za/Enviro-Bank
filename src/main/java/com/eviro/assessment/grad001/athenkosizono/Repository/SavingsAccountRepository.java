package com.eviro.assessment.grad001.athenkosizono.Repository;

import com.eviro.assessment.grad001.athenkosizono.Domain.*;
import com.eviro.assessment.grad001.athenkosizono.Domain.Database.SystemDB;
import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Set;

public class SavingsAccountRepository implements AccountRepository {

    private static SavingsAccountRepository repository = null;
    private SystemDB systemDB;

    private SavingsAccountRepository(){
        systemDB = SystemDB.getSystemDB();
    }

    public static SavingsAccountRepository getSavingsAccountRepository(){
        if(repository == null){
            repository = new SavingsAccountRepository();
        }
        return repository;
    }

    @Override
    public void withdraw (String accountNum, BigDecimal amountToWithdraw) throws Exception {
        Account account = systemDB.findByAccountNum(accountNum);
        if(account == null){
            throw new AccountNotFoundException("AccountNotFoundException");
        }
        else {
            if (account instanceof SavingsAccount) {
                BigDecimal minLimit = account.getBalance().subtract(amountToWithdraw);
                if (minLimit.compareTo(BigDecimal.valueOf(1000)) < 0) {
                    throw new Exception("WithdrawalAmountTooLargeException");
                } else {
                    systemDB.remove(account);
                    account.setBalance(account.getBalance().subtract(amountToWithdraw));
                    systemDB.add(account);
                    System.out.println("Successfully withdrawn...");
                    System.out.println(account);
                }
            }
            else{
                throw new AccountNotFoundException("AccountNotFoundException: Possible different account type.");
            }
        }
    }

    @Override
    public Set<Account> getAll() {
        return systemDB.getAll();
    }

}
