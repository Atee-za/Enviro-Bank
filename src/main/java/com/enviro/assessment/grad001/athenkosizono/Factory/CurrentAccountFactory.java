package com.enviro.assessment.grad001.athenkosizono.Factory;

import com.enviro.assessment.grad001.athenkosizono.Domain.CurrentAccount;

public class CurrentAccountFactory {

    //Creating a new Instance of Current Account
    public static CurrentAccount createCurrentAccount(int id, long accountNum, double balance, double overdraft){
        return new CurrentAccount(id, accountNum, balance, overdraft);
    }
}
