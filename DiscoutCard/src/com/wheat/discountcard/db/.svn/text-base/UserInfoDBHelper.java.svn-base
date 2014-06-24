package com.wheat.discountcard.db;

/*
 * File Name：UserInfoDBHelper.java
 * Copyright：Copyright 2008-2013 CiWong.Inc. All Rights Reserved.
 * Description： UserInfoDBHelper.java
 * Modify By：PLA-ZJLIU
 * Modify Date：2013-12-5
 * Modify Type：Add
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 * @author PLA-ZJLIU
 * @version ciwong v.1.0 2013-12-5
 * @since ciwong v.1.0
 */
public class UserInfoDBHelper extends SQLiteOpenHelper
{

    private static String DB_NAME = "user_info.db";

    private static final int DB_VERSION_1 = 1;

    /**
     * 构造函数
     * 
     * @param context
     *            {@link Context}
     */
    public UserInfoDBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION_1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(UserInfoTable.CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

}
