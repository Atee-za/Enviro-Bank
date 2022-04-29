package com.eviro.assessment.grad001.athenkosizono.Service;

import com.eviro.assessment.grad001.athenkosizono.Domain.CurrentAccount;
import com.eviro.assessment.grad001.athenkosizono.Domain.Database.SystemDB;
import com.eviro.assessment.grad001.athenkosizono.Factory.CurrentAccountFactory;

import java.math.BigDecimal;

class CurrentAccountServiceTest {

    public static void main(String[] args) throws Exception {
        new CurrentAccountServiceTest().runAllCurrentAccountTests();
    }

    private static CurrentAccountService service = CurrentAccountService.getCurrentAccountService();
    private CurrentAccount currentAccount = CurrentAccountFactory.createCurrentAccount("1111",108,"123X5Y", BigDecimal.valueOf(5000), BigDecimal.valueOf(6000));
    private CurrentAccount currentAccount1 = CurrentAccountFactory.createCurrentAccount("8544",150,"PR454", BigDecimal.valueOf(-2000), BigDecimal.valueOf(8000));

    private static SystemDB systemDB = SystemDB.getSystemDB();

    //To check if Singleton if functioning correctly
    private static SystemDB systemDB2 = SystemDB.getSystemDB();

    private void runAllCurrentAccountTests() throws Exception {
        // Adding Accounts to database
        systemDB.add(currentAccount);
        systemDB.add(currentAccount1);

        currentAccountWithdraw();
        testExceededBalance();
        testWithdrawNotFound();
        testingSingleton();
        testGetAll();
    }

    private void currentAccountWithdraw() throws Exception {
        service.withdraw("123X5Y", BigDecimal.valueOf(10000));
        System.out.println("Test Pass {Current Account with account number 123X5Y successfully executed.}");
    }

    private void testExceededBalance(){
        // Making balance exceed maximum overdraft limit, expecting WithdrawalAmountTooLargeException
        try{
            service.withdraw("PR454",BigDecimal.valueOf(7000));
        }
        catch (Exception e){
            System.out.println("Test Pass {" + e.getMessage() + ".}");
        }
    }

    private void testWithdrawNotFound() {
        // Finding none existing account expecting AccountNotFoundException
        try{
            service.withdraw("XXX",BigDecimal.valueOf(2002));
            System.out.println("Test Fail {Withdrawal was success.}");
        }
        catch (Exception e){
            System.out.println("Test Pass {" + e.getMessage() + ".}");
        }
    }

    private void testingSingleton(){
        // Checking if database has only 1 instance
        if(systemDB.equals(systemDB2)){
            System.out.println("Test Pass {Accounts in SystemDB are in SystemDB2.}");
        }
        else {
            System.out.println("Test Fail {Other Accounts are not found.}");
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
