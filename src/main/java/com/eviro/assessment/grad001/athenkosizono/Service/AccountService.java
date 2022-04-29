package com.eviro.assessment.grad001.athenkosizono.Service;

import com.eviro.assessment.grad001.athenkosizono.Domain.Account;

import java.math.BigDecimal;
import java.util.Set;

public interface AccountService {

    public void withdraw(String accountNum, BigDecimal amountToWithdraw) throws Exception;

    public Set<Account> getAll();

}
