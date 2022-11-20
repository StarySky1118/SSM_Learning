package service;

import exception.BalanceNotEnoughException;

public interface AccountService {
    /**
     * 转账
     *
     * @param actOut 转出账户
     * @param actIn  转入账户
     * @param money 转账金额
     */
    void transfer(String actOut, String actIn, Double money) throws BalanceNotEnoughException;
}
