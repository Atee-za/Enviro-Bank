package com.eviro.assessment.grad001.athenkosizono.Repository;

import com.eviro.assessment.grad001.athenkosizono.Domain.CurrentAccount;
import com.eviro.assessment.grad001.athenkosizono.Domain.Database.SystemDB;
import com.eviro.assessment.grad001.athenkosizono.Factory.CurrentAccountFactory;

import java.math.BigDecimal;

class CurrentAccountRepositoryTest {

    public static void main(String[] args) throws Exception {
        new CurrentAccountRepositoryTest().runAllSavingsAccountTests();
    }

    private static CurrentAccountRepository repository = CurrentAccountRepository.getCurrentAccountRepository();
    private CurrentAccount currentAccount = CurrentAccountFactory.createCurrentAccount("1111",108,"123X5Y", BigDecimal.valueOf(5000), BigDecimal.valueOf(6000));
    private CurrentAccount currentAccount1 = CurrentAccountFactory.createCurrentAccount("8544",150,"PR454", BigDecimal.valueOf(-2000), BigDecimal.valueOf(8000));
    private static SystemDB systemDB = SystemDB.getSystemDB();

    private void runAllSavingsAccountTests() throws Exception {
        systemDB.add(currentAccount);
        systemDB.add(currentAccount1);

        currentAccountWithdraw();
        testExceededBalance();
        testWithdrawNotFound();
        testGetAll();
    }

    private void currentAccountWithdraw() throws Exception {
        repository.withdraw("123X5Y", BigDecimal.valueOf(10000));
        System.out.println("Test Pass {Current Account with account number 123X5Y successfully executed.}");
    }

    private void testExceededBalance(){
        // Making balance exceed maximum overdraft limit, expecting WithdrawalAmountTooLargeException
        try{
            repository.withdraw("PR454",BigDecimal.valueOf(7000));
        }
        catch (Exception e){
            System.out.println("Test Pass {" + e.getMessage() + ".}");
        }
    }

    private void testWithdrawNotFound() {
        // Finding none existing account expecting AccountNotFoundException
        try{
            repository.withdraw("XXX",BigDecimal.valueOf(2002));
            System.out.println("Test Fail {Withdrawal was success.}");
        }
        catch (Exception e){
            System.out.println("Test Pass {" + e.getMessage() + ".}");
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