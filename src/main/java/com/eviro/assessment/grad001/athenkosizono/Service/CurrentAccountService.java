package com.eviro.assessment.grad001.athenkosizono.Service;

import com.eviro.assessment.grad001.athenkosizono.Repository.CurrentAccountRepository;
import java.math.BigDecimal;


public class CurrentAccountService implements AccountService{

    private static CurrentAccountService service = null;
    private static CurrentAccountRepository repository = null;

    private CurrentAccountService(){
        repository = CurrentAccountRepository.getCurrentAccountRepository();
    }

    public static CurrentAccountService getCurrentAccountService(){
        if(service == null){
            service = new CurrentAccountService();
        }
        return service;
    }

    @Override
    public void withdraw(String accountNum, BigDecimal amountToWithdraw) throws Exception {
        repository.withdraw(accountNum, amountToWithdraw);
    }
}
