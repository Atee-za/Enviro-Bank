package com.enviro.assessment.grad001.athenkosizono.Factory;

import com.enviro.assessment.grad001.athenkosizono.Domain.CurrentAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentAccountFactoryTest {

    private static CurrentAccount currentAccount = CurrentAccountFactory.createCurrentAccount(150,"911119",850,6000);

    @Test
    void createCurrentAccount() {
        assertNotNull(currentAccount);
        assertEquals("911119", currentAccount.getAccountNum());
        System.out.println(currentAccount);
    }
}