package com.zzy.mimiSSM.pojo;

import java.math.BigDecimal;

public class Account {
    private Integer id;
    private String actNo;
    private BigDecimal balance;

    public Account() {
    }

    public Account(Integer id, String actNo, BigDecimal balance) {
        this.id = id;
        this.actNo = actNo;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actNo='" + actNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
