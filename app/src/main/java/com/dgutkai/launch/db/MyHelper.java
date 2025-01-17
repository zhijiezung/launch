package com.dgutkai.launch.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "mydata.db";  //数据库名称
    public static String TABLE_NAME = "setting"; //表名
    public static String TABLE_APPS = "apps"; // app表名
    public static String TABLE_CONTACTS = "contacts"; // 联系人表名

    /**
     * super(参数1，参数2，参数3，参数4)，其中参数4是代表数据库的版本，
     * 是一个大于等于1的整数，如果要修改（添加字段）表中的字段，则设置
     * 一个比当前的 参数4 大的整数 ，把更新的语句写在onUpgrade(),下一次调用
     */
    public MyHelper(Context context) {
        super(context, DB_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("table oncreate", "create table");

        //Create table
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                "key TEXT PRIMARY KEY," +
                "value TEXT);";

        String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_APPS + "(" +
                "id TEXT PRIMARY KEY," +
                "name TEXT, " +
                "package TEXT);";

        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "(" +
                "id TEXT PRIMARY KEY," +
                "name TEXT, " +
                "number TEXT, " +
                "sortKey TEXT);";

        db.execSQL(sql);        //创建表
        db.execSQL(sql1);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*String sql = "INSERT INTO " + TABLE_NAME + " (key, value) VALUES ('show', 9);";  // 指针时钟 widgetID=9
        db.execSQL(sql);*/
    }
}
