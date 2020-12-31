package com.gaojun.sendmagdemo.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * @author RD-WJ-GJ
 * @time 2020/12/30 9:49
 */
@Database(entities = {User.class,}, version = 3)
public abstract class AppDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "my_db";

    private static AppDataBase databaseInstance;

    private static final Migration migration1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // 添加一个sex字段
            database.execSQL("ALTER TABLE table_user ADD COLUMN sex TEXT");
        }
    };

    private static final Migration migration2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // 添加一个phone字段
            database.execSQL("ALTER TABLE table_user ADD COLUMN phone TEXT");
        }
    };

    public static synchronized AppDataBase getInstance(Context context) {
        if (databaseInstance == null) {
            databaseInstance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .addMigrations(migration1_2, migration2_3)
                .build();
        }
        return databaseInstance;
    }

    public abstract UserDao studentDao();
}
