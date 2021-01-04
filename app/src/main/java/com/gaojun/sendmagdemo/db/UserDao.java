package com.gaojun.sendmagdemo.db;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;


/**
 * dao接口,可以操作User表
 *
 * @author Gaojun
 * @time 2020/12/31 15:46
 */
@Dao
public interface UserDao {
    // 插入一个User对象数据
    @Insert
    void insertUser(User user);

    // 删除一个User对象数据
    @Delete
    void deleteUser(User user);

    //删除指定名字的User数据
    @Query("DELETE FROM user WHERE name = :name")
    void deleteUserByName(String name);

    // 更新User数据
    @Update
    void upDataUser(User user);

    // 查询全部的User数据集合,这里使用LiveData来对数据进行包装,以便数据变化时,liveData可以自动感知,通知界面进行更新
    @Query("SELECT * FROM user")
    LiveData<List<User>> getUserList();

    @Query("SELECT * FROM user WHERE name = :name")
    LiveData<User> getUser(String name);

    // 根据id来查询数据,同样使用liveData对数据进行包装
    @Query("SELECT * FROM user WHERE id = :id")
    LiveData<List<User>> getUserListById(int id);

    @Insert
    void insertBookList(List<Book> bookList);

    @Transaction
    @Query("SELECT * FROM user")
    LiveData<List<UserAndBooks>> loadUserWithBooks();
}
