package com.gaojun.sendmagdemo.db;

import com.gaojun.sendmagdemo.GsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;


/**
 * 这是一个转换器,主要是用来往数据库存储自定义的数据类型,比如,对象里面嵌套对象,或者嵌套集合这种的类型.被嵌套的数据类型,会被转换成一个字符串,当做一个字段被储存在数据库,
 * 如果不想存成字符串,就不能使用转换器,请参考UserAndBooks这个类的形式进行操作
 *
 * @author Gaojun
 * @time 2021/1/4 10:19
 */
public class UserConverter {

//    @TypeConverter
//    public String objectToString(List<User.Book> result) {
//        try {
//            return GsonUtil.getInstance().objectToJson(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//    @TypeConverter
//    public List<User.Book> stringToObject(String json) {
//        Type listType = new TypeToken<List<User.Book>>() {
//        }.getType();
//        try {
//            return GsonUtil.getInstance().jsonStringToObject(listType, json);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
