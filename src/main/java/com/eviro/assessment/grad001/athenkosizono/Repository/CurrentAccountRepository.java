package com.eviro.assessment.grad001.athenkosizono.Repository;

import com.eviro.assessment.grad001.athenkosizono.Domain.*;
import com.eviro.assessment.grad001.athenkosizono.Domain.Database.SystemDB;
import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Set;

public class CurrentAccountRepository implements AccountRepository {

    private static CurrentAccountRepository repository = null;
    private SystemDB systemDB;

    private CurrentAccountRepository(){
        systemDB = SystemDB.getSystemDB();
    }

    public static CurrentAccountRepository getCurrentAccountRepository(){
        if(repository == null){
            repository = new CurrentAccountRepository();
        }
        return repository;
    }

    @Override
    public void withdraw (String accountNum, BigDecimal amountToWithdraw) throws Exception {
        Account account = systemDB.findByAccountNum(accountNum);
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
                    systemDB.remove(account);
                    account.setBalance(account.getBalance().subtract(amountToWithdraw));
                    systemDB.add(account);
                    System.out.println("Successfully withdrawn...");
                    System.out.println(account);
                }
            }
            else {
                throw new AccountNotFoundException("AccountNotFoundException: Possible different account type.");
            }
        }
    }

    @Override
    public Set<Account> getAll() {
        return systemDB.getAll();
    }

}
