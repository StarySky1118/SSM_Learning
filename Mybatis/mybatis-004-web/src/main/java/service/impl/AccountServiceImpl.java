package service.impl;

import dao.ActDao;
import dao.impl.ActDaoImpl;
import exception.BalanceNotEnoughException;
import org.apache.ibatis.session.SqlSession;
import pojo.Account;
import service.AccountService;
import utils.MybatisUtils;

public class AccountServiceImpl implements AccountService {
    private ActDao actDao = new ActDaoImpl();

    @Override
    public void transfer(String actOut, String actIn, Double money) throws BalanceNotEnoughException {
        // 获取转出账户余额
        Account accountOut = actDao.queryAccount(actOut);
        Double balance = accountOut.getBalance();

        // 余额小于转账金额，抛余额不足异常
        if (balance < money) {
            throw new BalanceNotEnoughException("余额不足，无法转账！");
        }

        // 获取装入账户对象
        Account accountIn = actDao.queryAccount(actIn);

        // 更新内存中账户金额
        accountOut.setBalance(balance - money);
        accountIn.setBalance(accountIn.getBalance() + money);

        // 获取 sqlSession
        SqlSession sqlSession = MybatisUtils.openSession();

        try {
            // 更新数据库账户金额
            actDao.update(actOut, accountOut.getBalance());
            int a = 12 / 0;
            actDao.update(actIn, accountIn.getBalance());

            // 事务提交
            sqlSession.commit();
        } catch (Exception e) {
            // 事务回滚
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            // 释放资源
            MybatisUtils.close(sqlSession);
        }
    }
}
