package com.gaojun.sendmagdemo.db;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 创建一个全局的常量池,作为操作数据库时开启线程和管理线程使用
 *
 * @author Gaojun
 * @time 2020/12/31 12:13
 */
public class DBThreadUtil {

    private ExecutorService fixedThreadPool;

    private static DBThreadUtil mDbThreadUtil;

    private DBThreadUtil() {
        if (null == fixedThreadPool) {
            fixedThreadPool = Executors.newFixedThreadPool(3);
        }
    }

    public static DBThreadUtil getInstance() {
        if (null == mDbThreadUtil) {
            synchronized (DBThreadUtil.class) {
                if (null == mDbThreadUtil) {
                    mDbThreadUtil = new DBThreadUtil();
                }
            }
        }
        return mDbThreadUtil;
    }

    public void executeRunnable(Runnable mRunnable) {
        fixedThreadPool.execute(mRunnable);
    }
}
