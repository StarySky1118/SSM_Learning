package dao;

import pojo.Account;

/**
 * 账户 Dao 对象，Dao 与业务逻辑不挂钩，只是 CRUD。
 */
public interface ActDao {
    int insertAct(Account account);

    /**
     * 更新账户余额
     *
     * @param actNo   账户
     * @param balance 余额
     * @return 受影响的记录条数
     */
    int update(String actNo, Double balance);

    /**
     * 根据账户编号查询账户信息
     * @param actNo 账户编号
     * @return 账户对象
     */
    Account queryAccount(String actNo);
}
