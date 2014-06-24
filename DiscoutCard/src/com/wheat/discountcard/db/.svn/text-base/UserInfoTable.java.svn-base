package com.wheat.discountcard.db;

/*
 * File Name：UserInfoTable.java
 * Copyright：Copyright 2008-2013 CiWong.Inc. All Rights Reserved.
 * Description： UserInfoTable.java
 * Modify By：PLA-ZJLIU
 * Modify Date：2013-12-5
 * Modify Type：Add
 */

import android.provider.BaseColumns;

/**
 * 用户表
 * 
 * @author PLA-ZJLIU
 * @version ciwong v.1.0 2013-12-5
 * @since ciwong v.1.0
 */
public class UserInfoTable implements BaseColumns {
	
	public static final String CREATE_SQL;

	public static final String TABLE_NAME = "user_info";

	/** 用户名称 */
	public static final String FIRST_NAME = "firstName";

	/** 用户密码 */
	public static final String PWD = "pwd";

	/** 头像地址 */
	public static final String SEX = "sex";

	/** 账号 */
	public static final String PHONE = "phone";

	static {

		StringBuffer sb = new StringBuffer();
		sb.append("create table " + TABLE_NAME + "(");
		sb.append(_ID + " integer primary key autoincrement, ");
		sb.append(SEX + " integer, ");
		sb.append(FIRST_NAME + "  varchar(255), ");
		sb.append(PWD + "  varchar(255), ");
		sb.append(PHONE + " varchar(256))");
		CREATE_SQL = sb.toString();
	}

	/**
	 * 获取列名集合
	 * 
	 * @return 列名集合
	 */
	public static String[] getColumns() {
		return new String[] { _ID, SEX, FIRST_NAME, PWD, PHONE };
	}
}
