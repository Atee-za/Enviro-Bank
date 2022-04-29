package com.eviro.assessment.grad001.athenkosizono.Factory;

import com.eviro.assessment.grad001.athenkosizono.Domain.CurrentAccount;
import java.math.BigDecimal;

class CurrentAccountFactoryTest {

    public static void main(String[] args) {
        new CurrentAccountFactoryTest().runAllCurrentAccountFactoryTests();
    }

    private static CurrentAccount currentAccount1 = CurrentAccountFactory.createCurrentAccount("5744",150,"911119", BigDecimal.valueOf(850), BigDecimal.valueOf(99099));
    private static CurrentAccount currentAccount2 = CurrentAccountFactory.createCurrentAccount("7117",150,"455564", BigDecimal.valueOf(-50), BigDecimal.valueOf(100005));

    private void runAllCurrentAccountFactoryTests(){
        testCreateCurrentAccount();
        testCurrentAccountNotCreated();
        testCurrentAccountEquality();
    }

    private void testCreateCurrentAccount() {
        // Object is successfully instantiated because all requirements are met
        if(currentAccount1 != null){
            System.out.println("Test Pass {Current Account instance created successfully.}");
        }
        else{
            System.out.println("Test Fail {Current Account Not created.}");
        }
        System.out.println(currentAccount1);
    }

    private void testCurrentAccountNotCreated(){
        // Object is Null because Overdraft is over the limit
        if(currentAccount2 == null){
            System.out.println("Test Pass {Current Account NOT created because Overdraft is over limit.}");
        }
        else{
            System.out.println("Test Fail {Current Account created but Overdraft above limit.}");
        }
        System.out.println(currentAccount2);
    }

    private void testCurrentAccountEquality(){
        if(currentAccount1.getCustomerNum().equals("5744")){
            System.out.println("Test Pass {Customer number of Current Account is correct.}");
        }
        else{
            System.out.println("Test Fail {Customer number of Current Account is NOT correct.}");
        }
        System.out.println(currentAccount1);
    }
}