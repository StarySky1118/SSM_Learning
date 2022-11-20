package Dao;

import dao.ActDao;
import dao.impl.ActDaoImpl;
import org.junit.Test;
import pojo.Account;

public class ActDaoTest {
    ActDao actDao = new ActDaoImpl();

    @Test
    public void testInsertAct() {
        Account account = new Account(null, "003", 1000.0);
        int count = actDao.insertAct(account);
        System.out.println(count > 0 ? "插入成功！" : "插入失败");
    }

    @Test
    public void testQueryAccount() {
        Account account = actDao.queryAccount("001");
        System.out.println(account);
    }

    @Test
    public void testUpdate() {
        int count = actDao.update("003", 2000.0);
        System.out.println(count > 0 ? "更新成功！" : "更新失败");
    }
}