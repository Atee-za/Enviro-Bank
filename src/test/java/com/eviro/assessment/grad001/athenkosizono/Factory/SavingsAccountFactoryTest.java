package com.eviro.assessment.grad001.athenkosizono.Factory;

import com.eviro.assessment.grad001.athenkosizono.Domain.SavingsAccount;
import java.math.BigDecimal;

class SavingsAccountFactoryTest {

    public static void main(String[] args) {
        new SavingsAccountFactoryTest().runAllSavingsAccountFactoryTests();
    }

    private SavingsAccount savingsAccount1 = SavingsAccountFactory.createSavingsAccount("1010",110,"255552", BigDecimal.valueOf(1500));
    private SavingsAccount savingsAccount2 = SavingsAccountFactory.createSavingsAccount("7777",120,"877778", BigDecimal.valueOf(990));

    private void runAllSavingsAccountFactoryTests(){
        testCreateSavingsAccount();
        testSavingsAccountNotCreated();
        testSavingsAccountEquality();
    }

    private void testCreateSavingsAccount() {
        // Object is successfully instantiated all requirements are met
        if(savingsAccount1 != null){
            System.out.println("Test Pass {Savings Account created successfully.}");
        }
        else{
            System.out.println("Test Fail {Failed to create Savings Account instance.}");
        }
        System.out.println(savingsAccount1);
    }

    private void testSavingsAccountNotCreated(){
        // Object is Null because SavingsAccount balance is less tha 1000
        if(savingsAccount2 == null){
            System.out.println("Test Pass {Savings Account not created because balance is low.}");
        }
        else{
            System.out.println("Test Fail {Savings Account created but balance is low.}");
        }
        System.out.println(savingsAccount2);
    }

    private void testSavingsAccountEquality(){
        if(savingsAccount1.getAccountNum().equals("255552")){
            System.out.println("Test Pass {Savings Account Number is correct.}");
        }
        else{
            System.out.println("Test Fail {Savings Account Number NOT correct.}");
        }
        System.out.println(savingsAccount1);
    }

}