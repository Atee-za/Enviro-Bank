package com.eviro.assessment.grad001.athenkosizono.Service;

import com.eviro.assessment.grad001.athenkosizono.Domain.Database.SystemDB;
import com.eviro.assessment.grad001.athenkosizono.Domain.SavingsAccount;
import com.eviro.assessment.grad001.athenkosizono.Factory.SavingsAccountFactory;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

class SavingsAccountServiceTest {

    private static SavingsAccountService service = SavingsAccountService.getSavingsAccountService();
    private SavingsAccount savingsAccount = SavingsAccountFactory.createSavingsAccount("1111",108,"123X5Y", BigDecimal.valueOf(5000));
    private SavingsAccount savingsAccount1 = SavingsAccountFactory.createSavingsAccount("91112",555,"PR454", BigDecimal.valueOf(2000));
    private static SystemDB systemDB = SystemDB.getSystemDB();

    //To test singleton
    private static SystemDB systemDB2 = SystemDB.getSystemDB();

    public static void main(String[] args) throws Exception {
        new SavingsAccountServiceTest().runAllSavingsAccountTests();
    }

    private void runAllSavingsAccountTests() throws Exception {
        // Adding Accounts to database
        systemDB.add(savingsAccount);
        systemDB.add(savingsAccount1);

        testServiceWithdraw();
        testExceededBalance();
        testWithdrawNotFound();
        testSingleton();
        testGetAll();
    }

    private void testServiceWithdraw() throws Exception {
        // Savings Account '123X5Y' will be found, balance will be decremented
        try{
            service.withdraw("123X5Y",BigDecimal.valueOf(4000));
            System.out.println("Test Pass {Account with Account Number 2 Found and Successfully withdrawn.} ");
        }
        catch (Exception e){
            System.out.println("Test Fail {Balance NOT withdrawn.}");
        }
    }

    private void testExceededBalance(){
        // Making balance exceed minimum limit, expecting WithdrawalAmountTooLargeException
        try{
            service.withdraw("PR454",BigDecimal.valueOf(2000));
        }
        catch (Exception e){
            System.out.println("Test Pass {" + e.getMessage() + ".}");
        }
    }

    private void testWithdrawNotFound() {
        // Finding none existing account expecting AccountNotFoundException
        try{
            service.withdraw("9",BigDecimal.valueOf(2002));
        }
        catch (AccountNotFoundException e){
            System.out.println("Test Pass {" + e.getMessage() + ".}");
        }
        catch (Exception err){
            System.out.println("Test Fail {Account was found.}");
        }
    }

    private void testSingleton(){
        if(systemDB == systemDB2){
            System.out.println("Test Pass {Singleton is successfully applied.}");
        }
        else{
            System.out.println("Test Fail {Singleton is NOT applied.}");
        }
    }

    private void testGetAll(){
        if(service.getAll().size() > 0){
            System.out.println("Test Pass {All Accounts retrieved.}");
        }
        else{
            System.out.println("Test Fail {Could NOT retrieve all Accounts.}");
        }
        System.out.println(service.getAll());
    }

}