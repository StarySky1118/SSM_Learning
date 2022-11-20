package com.zzy.dynamic1.mapper;

import com.zzy.dynamic1.pojo.Book;
import com.zzy.dynamic1.utils.MybatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookMapperTest {
    @Test
    public void testInsertBook() {
        SqlSession sqlSession = MybatisUtils.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        int count = mapper.insertBook(new Book(null, "狂人日记", "鲁迅", BigDecimal.valueOf(20.0), 999, 56, "static/img/default.jpg"));
        sqlSession.commit();

        System.out.println(count > 0 ? "插入成功！" : "插入失败！");
    }

    @Test
    public void testQueryBookByNameAndAuthorAndSales() {
        SqlSession sqlSession = MybatisUtils.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = mapper.queryBookByNameAndAuthorAndSales("", "迅", null);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testDeleteByIds() {
        SqlSession sqlSession = MybatisUtils.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        Integer[] ids = {23, 24, 25};
        int count = mapper.deleteByIds(ids);
        System.out.println("删除的记录条数为：" + count);
    }
}
