package com.gaojun.sendmagdemo.db;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


/**
 * User表
 *
 * @author Gaojun
 * @time 2021/1/4 10:21
 */
@Entity(tableName = "user")
public class User {
    // @PrimaryKey标签用于指定该字段作为表的主键。 autoGenerate = true ,表示自动生成
    @PrimaryKey(autoGenerate = true)
    // @ColumnInfo标签可用于设置该字段存储在数据库表中的名字并指定字段的类型。
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    private int id;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    private String name;

    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.TEXT)
    private String age;

    @ColumnInfo(name = "sex", typeAffinity = ColumnInfo.TEXT)
    private String sex;

    @ColumnInfo(name = "courseId", typeAffinity = ColumnInfo.TEXT)
    private String courseId;

    @ColumnInfo(name = "phone", typeAffinity = ColumnInfo.TEXT)
    private String phone;

    @Ignore
    private List<Book> bookList;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {

    }
    /**
     * Room会使用这个构造器来存储数据，也就是当你从表中得到Student对象时候，Room会使用这个构造器
     *
     * @param name
     * @param age
     * @author Gaojun
     * @time 2020/12/30 10:15
     */
//    public User(String name, String age, String sex) {
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//    }
}
