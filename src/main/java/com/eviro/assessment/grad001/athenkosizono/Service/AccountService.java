package com.eviro.assessment.grad001.athenkosizono.Service;

import java.math.BigDecimal;

public interface AccountService {

    public void withdraw(String accountNum, BigDecimal amountToWithdraw) throws Exception;

}
