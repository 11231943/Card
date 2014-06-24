package com.wheat.discountcard.i;

/*
 * File Name：ILogin.java
 * Copyright：Copyright 2008-2013 CiWong.Inc. All Rights Reserved.
 * Description： ILogin.java
 * Modify By：PLA-ZJLIU
 * Modify Date：2013-5-10
 * Modify Type：Add
 */

/**
 * 登录返回接口
 * 
 * @author PLA-ZJLIU
 * @version ciwong v.1.0 2013-5-10
 * @since ciwong v.1.0
 */
public interface LoginListener
{
    /**
     * 登录成功<br />
     * 调用者可以处理数据显示等操作
     */
    void success();

    /**
     * 跳致登录界面用户没有做登录操作或没有登录成功直接返回<br />
     * 表示没有登录,则调用者需要提示用户无法获取数据或显示本地缓存数据
     */
    void noneOperate();

    /**
     * 取消登录<br />
     * 调用者可以处理相关操作
     */
    void cancelLogin();

    /**
     * 独立登录<br />
     * 调用者可以处理相关操作
     */
    void jumpLogin();

}
