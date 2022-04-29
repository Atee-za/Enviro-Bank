package com.enviro.assessment.grad001.athenkosizono.Factory;

import com.enviro.assessment.grad001.athenkosizono.Domain.CurrentAccount;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CurrentAccountFactoryTest {

    private static CurrentAccount currentAccount1 = CurrentAccountFactory.createCurrentAccount("5744",150,"911119", BigDecimal.valueOf(850), BigDecimal.valueOf(99099));
    private static CurrentAccount currentAccount2 = CurrentAccountFactory.createCurrentAccount("7117",150,"455564", BigDecimal.valueOf(-50), BigDecimal.valueOf(100005));

    @Test
    void createCurrentAccount() {
        // Object is successfully instantiated because all requirements are met
        assertNotNull(currentAccount1);
        assertEquals("911119", currentAccount1.getAccountNum());
        System.out.println(currentAccount1);
    }

    @Test
    void currentNotCreated(){
        // Object is Null because Overdraft is over the limit
        assertNull(currentAccount2);
        System.out.println(currentAccount2);
    }
}