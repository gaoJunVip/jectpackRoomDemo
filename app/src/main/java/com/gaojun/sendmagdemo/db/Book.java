package com.gaojun.sendmagdemo.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


/**
 * book表
 *
 * @author Gaojun
 * @time 2021/1/4 10:21
 */
@Entity
public class Book {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id", typeAffinity = ColumnInfo.INTEGER)
    private int id;

    @ColumnInfo(name = "book_name", typeAffinity = ColumnInfo.TEXT)
    private String bookName;

    @ColumnInfo(name = "book_price", typeAffinity = ColumnInfo.TEXT)
    private String price;

    @ColumnInfo(name = "user_id")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
