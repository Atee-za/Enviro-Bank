package com.enviro.assessment.grad001.athenkosizono.Factory;

import com.enviro.assessment.grad001.athenkosizono.Domain.SavingsAccount;

import java.math.BigDecimal;

public class SavingsAccountFactory {

    //Creating an Instance of Current Account with restriction
    public static SavingsAccount createSavingsAccount(String customerNum, int id, String accountNum, BigDecimal balance){
        if(balance.compareTo(BigDecimal.valueOf(1000)) < 0){
            return null;
        }
        else{
            return new SavingsAccount(customerNum, id, accountNum, balance);
        }
    }
}
