package com.enviro.assessment.grad001.athenkosizono.Factory;

import com.enviro.assessment.grad001.athenkosizono.Domain.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountFactoryTest {

    private static SavingsAccount savingsAccount = SavingsAccountFactory.createSavingsAccount(110,"255552",550);

    @Test
    void createSavingsAccount() {
        assertNotNull(savingsAccount);
        assertEquals(550, savingsAccount.getBalance());
        System.out.println(savingsAccount);
    }
}