package com.enviro.assessment.grad001.athenkosizono.Factory;

import com.enviro.assessment.grad001.athenkosizono.Domain.CurrentAccount;

import java.math.BigDecimal;

public class CurrentAccountFactory {

    //Creating a new Instance of Current Account with restriction
    public static CurrentAccount createCurrentAccount(String customerNum, int id, String accountNum, BigDecimal balance, BigDecimal overdraft){
        if (overdraft.compareTo(BigDecimal.valueOf(100000)) > 0) {
            return null;
        }
        else{
            return new CurrentAccount(customerNum, id, accountNum, balance, overdraft);
        }
    }
}
