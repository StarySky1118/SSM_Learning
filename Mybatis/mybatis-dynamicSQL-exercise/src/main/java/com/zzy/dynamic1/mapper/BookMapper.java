package com.zzy.dynamic1.mapper;

import com.zzy.dynamic1.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    /**
     * 插入一条图书记录
     * @param book 图书对象
     * @return 插入的记录条数
     */
    int insertBook(Book book);

    /**
     * 根据多个条件进行查询
     * @param name
     * @param author
     * @param sales
     * @return
     */
    List<Book> queryBookByNameAndAuthorAndSales(@Param("name") String name, @Param("author") String author, @Param("sales") Integer sales);

    /**
     * 根据 id 数据批量删除记录
     * @param ids id 数组
     * @return 删除的记录条数
     */
    int deleteByIds(@Param("ids") Integer[] ids);
}
