package com.zzy.sm.pojo;

import java.math.BigDecimal;

/**
 * 账户类
 */
public class Account {
    private Integer id; // 自增主键
    private String actNo; // 账户编号
    private BigDecimal balance; // 余额

    // 构造器
    public Account() {
    }

    public Account(Integer id, String actNo, BigDecimal balance) {
        this.id = id;
        this.actNo = actNo;
        this.balance = balance;
    }

    // getter and setter
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
