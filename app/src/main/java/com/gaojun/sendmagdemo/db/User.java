package com.gaojun.sendmagdemo.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author RD-WJ-GJ
 * @time 2020/12/30 10:03
 */
@Entity(tableName = "table_user")
public class User {
    // @PrimaryKey标签用于指定该字段作为表的主键。 autoGenerate = true ,表示自动生成
    @PrimaryKey(autoGenerate = true)
    // @ColumnInfo标签可用于设置该字段存储在数据库表中的名字并指定字段的类型。
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    public String name;

    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.TEXT)
    public String age;

    @ColumnInfo(name = "sex", typeAffinity = ColumnInfo.TEXT)
    public String sex;

    @ColumnInfo(name = "phone", typeAffinity = ColumnInfo.TEXT)
    public String phone;

    /**
     * Room会使用这个构造器来存储数据，也就是当你从表中得到Student对象时候，Room会使用这个构造器
     *
     * @param id
     * @param name
     * @param age
     * @author Gaojun
     * @time 2020/12/30 10:15
     */
    public User(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
