package com.eviro.assessment.grad001.athenkosizono.Domain;

import java.math.BigDecimal;

public abstract class Account {
    String customerNum;
    int id;
    String accountNum;
    BigDecimal balance;

    public Account(String customerNum, int id, String accountNum, BigDecimal balance) {
        this.customerNum = customerNum;
        this.id = id;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
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
}
