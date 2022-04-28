package com.enviro.assessment.grad001.athenkosizono.Domain;

public class CurrentAccount {
    private int id;
    private long accountNum;
    private double balance;
    private double overdraft;

    public CurrentAccount(int id, long accountNum, double balance, double overdraft) {
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

    public long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(long accountNum) {
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
