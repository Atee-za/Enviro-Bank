package com.eviro.assessment.grad001.athenkosizono.Repository;

import com.eviro.assessment.grad001.athenkosizono.Domain.Database.SystemDB;
import java.math.BigDecimal;

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
        systemDB.withdraw(accountNum, amountToWithdraw);
    }

}
