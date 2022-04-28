package com.enviro.assessment.grad001.athenkosizono.Domain;

public class CurrentAccount {
    private int id;
    private String accountNum;
    private double balance;
    private double overdraft;

    public CurrentAccount(int id, String accountNum, double balance, double overdraft) {
        this.id = id;
        this.accountNum = accountNum;
        this.balance = balance;
        this.overdraft = overdraft;
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

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "id=" + id +
                ", accountNum=" + accountNum +
                ", balance = R" + balance +
                ", overdraft = R" + overdraft +
                '}';
    }
}
