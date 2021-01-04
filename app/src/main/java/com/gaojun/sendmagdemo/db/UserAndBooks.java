package com.gaojun.sendmagdemo.db;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;


/**
 * 将User表和book表关联起来查询的实体类
 *
 * @author Gaojun
 * @time 2021/1/4 10:17
 */
public class UserAndBooks {
    // 查询所有的User数据
    @Embedded
    public User user;

    // 主键是User表的name,外键是book表的user_id,进行的关联查询,返回一个book集合
    @Relation(parentColumn = "name", entityColumn = "user_id", entity = Book.class)
    public List<Book> bookList;
}
