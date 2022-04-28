package com.enviro.assessment.grad001.athenkosizono.Factory;

import com.enviro.assessment.grad001.athenkosizono.Domain.SavingsAccount;

public class SavingsAccountFactory {

    public static SavingsAccount createSavingsAccount(int id, long accountNum, double balance){
        return new SavingsAccount(id, accountNum, balance);
    }
}
