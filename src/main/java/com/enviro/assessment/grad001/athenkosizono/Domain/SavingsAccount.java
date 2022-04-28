package com.enviro.assessment.grad001.athenkosizono.Domain;

public class SavingsAccount {
    private int id;
    private String accountNum;
    private double balance;

    public SavingsAccount(int id, String accountNum, double balance){
        this.id = id;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNumber(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "id=" + id +
                ", accountNum=" + accountNum +
                ", balance = R" + balance +
                '}';
    }
}
