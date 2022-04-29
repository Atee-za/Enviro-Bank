package com.eviro.assessment.grad001.athenkosizono.Repository;

import com.eviro.assessment.grad001.athenkosizono.Domain.Database.SystemDB;
import com.eviro.assessment.grad001.athenkosizono.Domain.SavingsAccount;
import com.eviro.assessment.grad001.athenkosizono.Factory.SavingsAccountFactory;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

class SavingsAccountRepositoryTest {

    public static void main(String[] args) throws Exception {
        //Run tests
        new SavingsAccountRepositoryTest().runAllSavingsAccountTests();
    }

    private static SavingsAccountRepository repository = SavingsAccountRepository.getSavingsAccountRepository();
    private SavingsAccount savingsAccount = SavingsAccountFactory.createSavingsAccount("1111",108,"123X5Y", BigDecimal.valueOf(5000));
    private SavingsAccount savingsAccount1 = SavingsAccountFactory.createSavingsAccount("91112",555,"PR454", BigDecimal.valueOf(2000));
    private static SystemDB systemDB = SystemDB.getSystemDB();

    private void runAllSavingsAccountTests() throws Exception {
        systemDB.add(savingsAccount);
        systemDB.add(savingsAccount1);
        testRepositoryWithdraw();
        testExceededBalance();
        testWithdrawNotFound();
        testGetAll();
    }

    private void testRepositoryWithdraw() throws Exception {
        // Savings Account '123X5Y' will be found, balance will be decremented
        try{
            repository.withdraw("123X5Y",BigDecimal.valueOf(4000));
            System.out.println("Test Pass {Account with Account Number 2 Found and Successfully withdrawn.} ");
        }
        catch (Exception e){
            System.out.println("Test Fail {Balance NOT withdrawn.}");
        }
    }

    private void testExceededBalance(){
        // Making balance exceed minimum limit, expecting WithdrawalAmountTooLargeException
        try{
            repository.withdraw("PR454",BigDecimal.valueOf(2000));
        }
        catch (Exception e){
            System.out.println("Test Pass {" + e.getMessage() + ".}");
        }
    }

    private void testWithdrawNotFound() {
        // Finding none existing account expecting AccountNotFoundException
        try{
            repository.withdraw("9",BigDecimal.valueOf(2002));
        }
        catch (AccountNotFoundException e){
            System.out.println("Test Pass {" + e.getMessage() + ".}");
        }
        catch (Exception err){
            System.out.println("Test Fail {Account was found.}");
        }
    }

    private void testGetAll(){
        if(repository.getAll().size() > 0){
            System.out.println("Test Pass {All Accounts retrieved.}");
        }
        else{
            System.out.println("Test Fail {Could NOT retrieve all Accounts.}");
        }
        System.out.println(repository.getAll());
    }

}