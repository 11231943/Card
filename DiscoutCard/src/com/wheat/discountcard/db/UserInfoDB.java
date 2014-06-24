package com.wheat.discountcard.db;

/*
 * File Name：UserInfoDB.java
 * Copyright：Copyright 2008-2013 CiWong.Inc. All Rights Reserved.
 * Description： UserInfoDB.java
 * Modify By：PLA-ZJLIU
 * Modify Date：2013-12-5
 * Modify Type：Add
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wheat.discountcard.bean.UserInfo;

/**
 * 用户信息数据库工具
 * 
 * @author PLA-ZJLIU
 * @version ciwong v.1.0 2013-12-5
 * @since ciwong v.1.0
 */
public class UserInfoDB {
	private static UserInfoDBHelper helper;

	private static Context mContext;

	/**
	 * 设置上下文
	 * 
	 * @param context
	 *            {@link Context}
	 */
	public static void setContext(Context context) {
		mContext = context;
	}

	private static SQLiteDatabase getReadableDatabase() {
		if (helper == null) {
			helper = new UserInfoDBHelper(mContext);
		}
		return helper.getReadableDatabase();
	}

	private static SQLiteDatabase getWritableDatabase() {
		if (helper == null) {
			helper = new UserInfoDBHelper(mContext);
		}
		return helper.getWritableDatabase();
	}

	private static void closeWidthTransaction(SQLiteDatabase db) {
		db.endTransaction();
		close(db);
	}

	private static void close(SQLiteDatabase db) {
		db.close();
		helper.close();
	}

	static synchronized ContentValues getContentValues(UserInfo UserInfo) {
		ContentValues cvs = new ContentValues();
		cvs.put(UserInfoTable.FIRST_NAME, UserInfo.getFirstName());
		cvs.put(UserInfoTable.PHONE, UserInfo.getPhone());
		cvs.put(UserInfoTable.PWD, UserInfo.getPwd());
		cvs.put(UserInfoTable.SEX, UserInfo.getSex());
		cvs.put(UserInfoTable._ID, UserInfo.getId());
		return cvs;
	}

	/**
	 * 
	 * 更新数据
	 * 
	 * @param db
	 *            {@link SQLiteDatabase}
	 * @param user
	 *            {@link PlayHistory}
	 * @return 修改是否成功
	 */
	static synchronized boolean modify(SQLiteDatabase db, UserInfo user) {
		return db.update(UserInfoTable.TABLE_NAME, getContentValues(user),
				UserInfoTable._ID, new String[] { user.getId() + "" }) == 1;
	}

	/**
	 * 
	 * 添加数据
	 * 
	 * @param db
	 *            {@link SQLiteDatabase}
	 * @param user
	 *            {@link PlayHistory}
	 * @return 插入是否成功
	 */
	static synchronized boolean add(SQLiteDatabase db, UserInfo user) {
		return db
				.insert(UserInfoTable.TABLE_NAME, null, getContentValues(user)) > 0;
	}

	/**
	 * 
	 * 删除记录
	 * 
	 * @param db
	 *            {@link SQLiteDatabase}
	 * @param UserInfo
	 *            {@link UserInfo}
	 * @return 删除是否成功
	 */
	static synchronized boolean del(SQLiteDatabase db, UserInfo UserInfo) {
		return db.delete(UserInfoTable.TABLE_NAME, UserInfoTable._ID + " = ?",
				new String[] { UserInfo.getId() + "" }) == 1;
	}

	/**
	 * 
	 * 删除记录
	 * 
	 * @param db
	 *            {@link SQLiteDatabase}
	 * @param userId
	 *            用户ID
	 * @return 删除是否成功
	 */
	static synchronized boolean del(SQLiteDatabase db, long userId) {
		UserInfo UserInfo = new UserInfo();
		UserInfo.setId(userId);
		return db.delete(UserInfoTable.TABLE_NAME, UserInfoTable._ID + " = ?",
				new String[] { UserInfo.getId() + "" }) == 1;
	}

	/**
	 * 插入用户信息
	 * 
	 * @param UserInfo
	 *            {@link UserInfo}
	 * @return 插入是否成功
	 */
	public static synchronized boolean addUserInfo(UserInfo UserInfo) {
		boolean ret = false;
		SQLiteDatabase db = getWritableDatabase();
		try {
			db.beginTransaction();
			Cursor c = db.query(UserInfoTable.TABLE_NAME,
					new String[] { UserInfoTable._ID }, UserInfoTable._ID
							+ " = ?", new String[] { UserInfo.getId() + "" },
					null, null, null);
			if (c.moveToNext()) {
				ret = modify(db, UserInfo);
			} else {
				ret = add(db, UserInfo);
			}
			if (ret) {
				db.setTransactionSuccessful();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeWidthTransaction(db);
		}
		return ret;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param UserInfo
	 *            {@link UserInfo}
	 * @return 修改是否成功
	 */
	public static synchronized boolean modifyUserInfo(UserInfo UserInfo) {
		boolean ret = false;
		SQLiteDatabase db = getWritableDatabase();
		try {
			db.beginTransaction();
			ret = modify(db, UserInfo);
			if (ret) {
				db.setTransactionSuccessful();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeWidthTransaction(db);
		}
		return ret;
	}

	/**
	 * 查找所有的用户
	 * 
	 * @return List<{@link UserInfo}>
	 */
	public static synchronized List<UserInfo> getUserInfos() {
		List<UserInfo> UserInfos = new ArrayList<UserInfo>();
		UserInfo mUserInfo = null;
		SQLiteDatabase db = getReadableDatabase();
		try {
			Cursor cursor = db.query(UserInfoTable.TABLE_NAME,
					UserInfoTable.getColumns(), null, null, null, null, null);
			while (cursor.moveToNext()) {
				mUserInfo = read(cursor);
				UserInfos.add(mUserInfo);
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(db);
		}
		return UserInfos;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param UserInfo
	 *            {@link UserInfo}
	 * @return 修改是否成功
	 */
	public static synchronized UserInfo getUserInfo(long userId) {
		UserInfo mUserInfo = null;
		SQLiteDatabase db = getReadableDatabase();
		try {
			Cursor cursor = db.query(UserInfoTable.TABLE_NAME,
					UserInfoTable.getColumns(), UserInfoTable._ID + " = ?",
					new String[] { userId + "" }, null, null, null);
			if (cursor.moveToNext()) {
				mUserInfo = read(cursor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(db);
		}
		return mUserInfo;
	}

	static synchronized UserInfo read(Cursor c) {
		UserInfo UserInfo = new UserInfo();
		UserInfo.setId(c.getLong(0));
		UserInfo.setSex(c.getInt(1));
		UserInfo.setFirstName(c.getString(2));
		UserInfo.setPhone(c.getString(4));
		UserInfo.setPwd(c.getString(3));
		return UserInfo;
	}
}
