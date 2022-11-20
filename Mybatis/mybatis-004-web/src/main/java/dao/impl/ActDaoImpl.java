package dao.impl;

import dao.ActDao;
import org.apache.ibatis.session.SqlSession;
import pojo.Account;
import utils.MybatisUtils;

public class ActDaoImpl implements ActDao {
    @Override
    public int insertAct(Account account) {
        // 开启事务
        SqlSession sqlSession = MybatisUtils.openSession();
        // 执行sql
        int effectedRows = sqlSession.insert("insertAct", account);

        return effectedRows;
    }

    @Override
    public int update(String actNo, Double balance) {
        Account account = new Account(null, actNo, balance);
        // 开启事务
        SqlSession sqlSession = MybatisUtils.openSession();
        int count = sqlSession.update("account.updateBalance", account);
        return count;
    }

    @Override
    public Account queryAccount(String actNo) {
        SqlSession sqlSession = MybatisUtils.openSession();
        Account account = sqlSession.selectOne("selectOneAccount", actNo);
        return account;
    }
}
