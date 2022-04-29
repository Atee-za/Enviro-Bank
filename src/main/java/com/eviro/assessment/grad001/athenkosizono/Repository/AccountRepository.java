package com.eviro.assessment.grad001.athenkosizono.Repository;

import java.math.BigDecimal;

public interface AccountRepository {
    public void withdraw (String accountNum, BigDecimal amountToWithdraw) throws Exception;
}
