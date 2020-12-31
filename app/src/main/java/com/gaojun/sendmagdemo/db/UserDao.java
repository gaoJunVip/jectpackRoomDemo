package com.gaojun.sendmagdemo.db;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * @author RD-WJ-GJ
 * @time 2020/12/30 13:51
 */
@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM table_user WHERE name = :name")
    void deleteUserByName(String name);

    @Update
    void upDataUser(User user);

    @Query("SELECT * FROM table_user")
    LiveData<List<User>> getUserList();

    @Query("SELECT * FROM table_user WHERE id = :id")
    LiveData<List<User>> getUserListById(int id);
}
