package com.enviro.assessment.grad001.athenkosizono.Factory;

import com.enviro.assessment.grad001.athenkosizono.Domain.SavingsAccount;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountFactoryTest {

    private SavingsAccount savingsAccount1 = SavingsAccountFactory.createSavingsAccount("1010",110,"255552", BigDecimal.valueOf(1500));
    private SavingsAccount savingsAccount2 = SavingsAccountFactory.createSavingsAccount("7777",120,"877778", BigDecimal.valueOf(990));

    @Test
    void createSavingsAccount() {
        // Object is successfully instantiated all requirements are met
        assertNotNull(savingsAccount1);
        assertEquals(BigDecimal.valueOf(1500), savingsAccount1.getBalance());
        System.out.println(savingsAccount1);
    }

    @Test
    void savingsNotCreated(){
        // Object is Null because SavingsAccount balance is less tha 1000
        assertNull(savingsAccount2);
        System.out.println(savingsAccount2);
    }
}