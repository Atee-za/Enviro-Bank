package com.eviro.assessment.grad001.athenkosizono.Service;

import com.eviro.assessment.grad001.athenkosizono.Repository.SavingsAccountRepository;
import java.math.BigDecimal;

public class SavingsAccountService implements AccountService{

    private static SavingsAccountService service = null;
    private static SavingsAccountRepository repository = null;

    private SavingsAccountService(){
        repository = SavingsAccountRepository.getSavingsAccountRepository();
    }

    public static SavingsAccountService getSavingsAccountService(){
        if(service == null){
            service = new SavingsAccountService();
        }
        return service;
    }

    @Override
    public void withdraw(String accountNum, BigDecimal amountToWithdraw) throws Exception {
        repository.withdraw(accountNum, amountToWithdraw);
    }
}
