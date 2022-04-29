package com.enviro.assessment.grad001.athenkosizono.Domain;

import java.math.BigDecimal;

public class SavingsAccount extends Account{

    public SavingsAccount(String customerNum, int id, String accountNum, BigDecimal balance){
        super(customerNum, id, accountNum, balance);
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "customerNum='" + customerNum + '\'' +
                ", id=" + id +
                ", accountNum='" + accountNum + '\'' +
                ", balance = R" + balance +
                '}';
    }
}
