package com.eviro.assessment.grad001.athenkosizono;

import com.eviro.assessment.grad001.athenkosizono.Domain.Account;
import com.eviro.assessment.grad001.athenkosizono.Domain.Database.SystemDB;
import com.eviro.assessment.grad001.athenkosizono.Factory.*;
import com.eviro.assessment.grad001.athenkosizono.Service.CurrentAccountService;
import com.eviro.assessment.grad001.athenkosizono.Service.SavingsAccountService;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainApplication {

    private static SystemDB systemDB;
    private static Scanner sc;
    private static SavingsAccountService savingsAccountService;
    private static CurrentAccountService currentAccountService;

    public static void main(String[] args) throws Exception {
        systemDB = SystemDB.getSystemDB();
        systemDB.addAll(populateData());
        savingsAccountService = SavingsAccountService.getSavingsAccountService();
        currentAccountService = CurrentAccountService.getCurrentAccountService();
        sc = new Scanner(System.in);
        menu();
    }

    private static Set<Account> populateData(){
        Set<Account> accounts = new HashSet<>();
        accounts.add(SavingsAccountFactory.createSavingsAccount("4040",101,"1", BigDecimal.valueOf(2000)));
        accounts.add(SavingsAccountFactory.createSavingsAccount("3663",102,"2", BigDecimal.valueOf(5000)));
        accounts.add(CurrentAccountFactory.createCurrentAccount("5885",103,"3", BigDecimal.valueOf(1000), BigDecimal.valueOf(10000)));
        accounts.add(CurrentAccountFactory.createCurrentAccount("9111",104,"4", BigDecimal.valueOf(-5000), BigDecimal.valueOf(20000)));
        System.out.println("**Populated*******");
        accounts.forEach(System.out::println);
        System.out.println("******************");
        return accounts;
    }

    private static void menu() throws Exception {
        System.out.println("Welcome to Enviro-Bank\nPlease make a choice below.");
        System.out.println("\t1. Withdraw.\n\t2. View all accounts.\n\t3. Exit.");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                withdraw();
                break;
            case 2:
                viewAllData();
                break;
            default:
                System.out.println("Good bye!");
                System.exit(0);
        }
    }

    private static void viewAllData() throws Exception {
        System.out.println("All data.");
        Set<Account> allData = savingsAccountService.getAll();
        allData.forEach(System.out::println);
        menu();
    }

    private static void withdraw() throws Exception {
        System.out.println("Select account type you want to withdraw from.\n\t1. Savings Account.\n\t2. Current Account.");
        int accountType = sc.nextInt();
        System.out.println("Enter Account Number.");
        String accountNum = sc.next();
        System.out.println("Enter Amount to withdraw.");
        BigDecimal amount = sc.nextBigDecimal();
        if(!accountNum.isEmpty() && !amount.equals("")){
            try{
                if(accountType == 1){
                    savingsAccountService.withdraw(accountNum, amount);
                }
                else if(accountType == 2){
                    currentAccountService.withdraw(accountNum, amount);
                }
                else{
                    System.out.println("Invalid Account type...try again");
                }
            }
            catch (AccountNotFoundException e){
                System.out.println("Account Not found!");
            }
            catch (Exception err){
                System.out.println("Withdrawal too large!");
            }
        }
        else{
            System.out.println("Data NOT provided. try again...");
        }
        menu();
    }

}
