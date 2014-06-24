package com.wheat.discountcard.ui.base;

/*
 * File Name：P1PBaseActivityGroup.java
 * Copyright：Copyright 2008-2013 CiWong.Inc. All Rights Reserved.
 * Description： P1PBaseActivityGroup.java
 * Modify By：PLA-ZJLIU
 * Modify Date：2013-5-10
 * Modify Type：Add
 */

import android.content.Intent;
import android.os.Bundle;
import cn.wheat.libs.activity.CWBaseActivityGroup;

import com.wheat.discountcard.application.LSBApplication;
import com.wheat.discountcard.bean.UserInfo;
import com.wheat.discountcard.i.LoginListener;

/**
 * 
 * @author PLA-ZJLIU
 * @version ciwong v.1.0 2013-5-10
 * @since ciwong v.1.0
 */
public abstract class TPBaseActivityGroup extends CWBaseActivityGroup
{
    /**
     * Intent键值,存储标题栏的返回按钮显示字符
     */
    public static final String GO_BACK = "GO_BACK";

    /**
     * 默认标题栏返回按钮显示字符:"返回"
     */
    public static final int DEF_GO_BACK = -1;

    /**
     * 登录请求码
     */
    private static final int REQUEST_CODE_LOGIN = 0x54784f;

    protected boolean isForbiddenTitleBar;// 是否禁用标题栏
    
    private LoginListener mLoginListener;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    	
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (getUserInfo() == null)
        {
          //  loginFromShareData();
        }
//        MobileProbe.onResume(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
//        MobileProbe.onPause(this);
    }

    /**
     * 启动Activity,如标题栏不需要返回按钮(即隐藏)则调用 {@link #startActivity(Intent)}<br />
     * 如需使用默认值则参数goBackResId什为{@link #DEF_GO_BACK}
     * 
     * @param mIntent
     *            {@link Intent}
     * @param goBackResId
     *            标题栏返回按钮显示字符(如:拍一拍、学习圈)
     */
    protected void startActivity(Intent mIntent, int goBackResId)
    {
        mIntent.putExtra(GO_BACK, goBackResId);
        startActivity(mIntent);
    }

    /**
     * 
     * 启动Activity,如标题栏不需要返回按钮(即隐藏)则调用 {@link #startActivity(Intent)}<br />
     * 如需使用默认值则参数goBackResId什为{@link #DEF_GO_BACK}
     * 
     * @param intent
     *            {@link Intent}
     * @param requestCode
     *            If >= 0, this code will be returned in onActivityResult() when
     *            the activity exits.
     * @param goBackResId
     *            标题栏返回按钮显示字符(如:拍一拍、学习圈)
     */
    public void startActivityForResult(Intent intent, int requestCode,
            int goBackResId)
    {
        intent.putExtra(GO_BACK, goBackResId);
        super.startActivityForResult(intent, requestCode);
    }

    /**
     * 验证是否登录
     * 
     * @return 是否登录
     */
    protected boolean validLogin()
    {
        UserInfo mUserInfo = getUserInfo();
        if (mUserInfo == null)
        {
            return false;
        }
        return true;
    }

    /**
     * 验证是否过期
     * 
     * @param resultCode
     *            请求返回码
     * @return 账号是否已过期
     */
    protected boolean validAccountExpire(int resultCode, LoginListener listener)
    {
        if (100008 == resultCode)
        {
       //     Login(listener, true);
            return false;
        }
        return true;
    }

    /**
     * 获取全局Application
     * 
     * @return {@link LSBApplication}
     */
    protected LSBApplication getLSBApplication()
    {
        LSBApplication application = (LSBApplication) getApplication();
        return application;
    }

    private void loginCallback(UserInfo user)
    {
        if (mLoginListener != null)
        {
            if (user != null)
            {
                mLoginListener.success();
            }
            else
            {
                mLoginListener.noneOperate();
            }
        }
    }
//
//    /**
//     * 登录<br />
//     * 当用户请求数据时,而没有登录调用的方法.<br />
//     * {@link LoginListener}实现两个方法,详情查看接口说明
//     * 
//     * @param listener
//     *            {@link LoginListener}
//     * @param isExpire
//     *            账号信息是否已过期
//     */
//    protected void Login(LoginListener listener, boolean isExpire)
//    {
//        mLoginListener = listener;
//        if (getLSBApplication().isAppLogin())
//        {
//            Intent mIntent = new Intent(this, LoginActivity.class);
//            if (isExpire)
//            {
//                mIntent.putExtra(LoginActivity.LOGIN_EXPIRE, true);
//            }
//            mIntent.putExtra(LoginActivity.USER_LOGIN, true);
//            startActivityForResult(mIntent, REQUEST_CODE_LOGIN);
//        }
//        else
//        {
//            loginFromShareData();
//        }
//    }
//
//    private void loginFromShareData()
//    {
//        boolean isLogin = UsersUtil.isLogin(this, null, null, null, null);
//        if (isLogin)
//        {
//            UserInfo user = getUserInfoFromShareData();
//            loginCallback(user);
//        }
//        else
//        {
//            CWUtils.enterLogin(this);
//        }
//    }
//
//    private UserInfo getUserInfoFromShareData()
//    {
//        Users user = UsersUtil.getUserInfo(this);
//        if (user == null)
//        {
//            return null;
//        }
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(user.getUserId());
//        userInfo.setAvatar(user.getAvatar());
//        userInfo.setRealName(user.getRealName());
//        userInfo.setClassInfo(user.getClassInfo());
//        setUserInfo(userInfo);
//        setVerifyInfo(user);
//        return userInfo;
//    }
//
//    private void setVerifyInfo(Users user)
//    {
//        if (user != null)
//        {
//            VerifyInfo verifyInfo = new VerifyInfo();
//            verifyInfo.setAccessToken(user.getAccess_token());
//            verifyInfo.setClientId("100002");
//            verifyInfo.setClientIp(com.ciwong.libs.utils.CWSys
//                    .getLocalIpAddress());
//            verifyInfo.setOauthVersion("2.a");
//            verifyInfo.setOpenId(user.getOpenid());
//            verifyInfo.setScope("all");
//            AsyncHttpRequest.setVerifyInfo(verifyInfo);
//        }
//        TPAction action = new TPAction();
//        AsyncHttpRequest.setRequestAction(action);
//        AsyncUploadLargeFile.setAction(action);
//    }

    /**
     * 登录<br />
     * 当用户请求数据时,而没有登录调用的方法.<br />
     * {@link LoginListener}实现两个方法,详情查看接口说明
     * 
     * @param listener
     *            {@link LoginListener}
     */
    protected void Login(LoginListener listener)
    {
     //   Login(listener, false);
    }

    /**
     * <span style="color:red">复写此方法时必须调用 <b style="color:blue">{@link
     * super.onActivityResult(int,int,Intent)}</b></span><br />
     * {@inheritDoc}
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUEST_CODE_LOGIN)
        {
            if (mLoginListener != null)
            {
                if (resultCode == RESULT_OK)
                {
                    mLoginListener.success();
                }
                else
                {
                    mLoginListener.noneOperate();
                }
            }
        }
        else if (requestCode == 1)// 数据共享登录请求码
        {
            if (resultCode == RESULT_OK)
            {
              //  UserInfo user = getUserInfoFromShareData();
            //    loginCallback(user);
            }
            else
            {
                finish();
            }
        }
    }

    /**
     * 获取用户信息
     * 
     * @return {@link UserInfo}
     */
    protected UserInfo getUserInfo()
    {
        LSBApplication application = (LSBApplication) getApplication();
        UserInfo mUserInfo = application.getUserInfo();
        return mUserInfo;
    }

    /**
     * 设置用户信息
     * 
     * @param userInfo
     *            {@link UserInfo}
     */
    protected void setUserInfo(UserInfo userInfo)
    {
        LSBApplication application = (LSBApplication) getApplication();
        application.setUserInfo(userInfo);
    }

}
