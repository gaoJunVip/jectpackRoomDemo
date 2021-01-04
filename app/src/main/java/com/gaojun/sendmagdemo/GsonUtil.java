package com.gaojun.sendmagdemo;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @author RD-WJ-GJ
 * @time 2021/1/3 11:59
 */
public class GsonUtil {
    private Gson gson = new Gson();

    public Gson getGson() {
        return this.gson;
    }

    public GsonUtil() {
    }

    public static GsonUtil getInstance() {
        return GsonUtil.GsonUtilHolder.GSON_UTIL;
    }

    public <T> T jsonStringToObject(Class<T> target, String json) throws Exception {
        return getInstance().getGson().fromJson(json, target);
    }

    public <T> T jsonStringToObject(Type typeOfT, String json) throws Exception {
        return getInstance().getGson().fromJson(json, typeOfT);
    }

    public String objectToJson(Object obj) throws Exception {
        return getInstance().getGson().toJson(obj);
    }

    private static class GsonUtilHolder {
        private static final GsonUtil GSON_UTIL = new GsonUtil();

        private GsonUtilHolder() {
        }
    }
}
