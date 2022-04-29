package com.enviro.assessment.grad001.athenkosizono.Domain;

import java.math.BigDecimal;

public class CurrentAccount extends Account{

    private BigDecimal overdraft;

    public CurrentAccount(String customerNum, int id, String accountNum, BigDecimal balance, BigDecimal overdraft) {
        super(customerNum, id, accountNum, balance);
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "customerNum='" + customerNum + '\'' +
                ", id=" + id +
                ", accountNum='" + accountNum + '\'' +
                ", balance = R" + balance +
                ", overdraft = R" + overdraft +
                '}';
    }
}
