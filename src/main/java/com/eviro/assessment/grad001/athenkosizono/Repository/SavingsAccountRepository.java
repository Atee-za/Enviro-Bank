package com.eviro.assessment.grad001.athenkosizono.Repository;

import com.eviro.assessment.grad001.athenkosizono.Domain.Database.SystemDB;
import java.math.BigDecimal;

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
        systemDB.withdraw(accountNum, amountToWithdraw);
    }

}
