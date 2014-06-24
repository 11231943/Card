package com.wheat.discountcard.utils;

import cn.wheat.libs.http.AsyncHttpRequest.CWAction;

/*
 * File Name：MAction.java
 * Copyright：Copyright 2008-2013 CiWong.Inc. All Rights Reserved.
 * Description： MAction.java
 * Modify By：Administrator
 * Modify Date：2013-12-28
 * Modify Type：Add
 */

/**
 * @author Administrator
 * @version ciwong v.1.0 2013-12-28
 * @since ciwong v.1.0
 */
public class MAction implements CWAction
{

    // public static final String HOST_IP = "http://192.168.120.12:8080";

    // public static final String HOST_IP = "http://192.168.4.101:8080";

    public static final String HOST_IP = "http://115.28.133.210:8080";

    public static final String HOST_SPEEKING = HOST_IP + "/VipCard/";

    /**
     * 更新路径
     */
    public static String UPGRADE_HD_URL = HOST_IP
            + "/UpdateApk/discoundCard_update.xml";

    /**
     * 短信验证
     */
    public static final String ACTION_DO_VERIFY = HOST_SPEEKING
            + "doUser!doVerify?";

    /**
     * 获取列表优惠
     */
    public static final String ACTION_GET_DISCOUNT_LIST = HOST_SPEEKING
            + "doDis!listMainDiscountByPage?";

    /**
     * 获取单条优惠
     */
    public static final String ACTION_GET_DISCOUNT_LIST_BUYID = HOST_SPEEKING
            + "doDis!getDiscountById?";

    /**
     * 根据主优惠卷disId查询
     */
    public static final String ACTION_GET_DISCOUNT_BY_DISID = HOST_SPEEKING
            + "doDis!getDiscountByDisId?";

    /**
     * 获取优惠列表
     */
    public static final String ACTION_GET_DISCOUNT_LIST_DISID = HOST_SPEEKING
            + "doDis!listDiscountByPage?";

    /**
     * 通过ID获取商家信息
     */
    public static final String ACTION_GET_BUSINESS_BY_ID_LIST = HOST_SPEEKING
            + "doBusiness!getBusinessById?";

    /**
     * 获取会员卡
     * http://127.0.0.1:8080/MyVip/doVip!listCardTyeByPage?page=1&cardType=
     * 0&cardClass=1401
     */
    public static final String ACTION_GET_CARD_TYPE_LIST = HOST_SPEEKING
            + "doVip!listCardTyeByPage?";

    /**
     * 搜索会员卡
     * http://127.0.0.1:8080/MyVip/doVip!listCardTyeByPage?page=1&cardType=
     * 0&cardClass=1401
     */
    public static final String ACTION_SEARCH_CARD_LIST = HOST_SPEEKING
            + "doVip!searchCardList?";

    public static final String ACTION_SEARCH_DISCOUNT_LIST = HOST_SPEEKING
            + "doDis!searchDiscountList?";

    /**
     * 获取单个会员卡
     */
    public static final String ACTION_GET_CARD_CONTENT_LIST = HOST_SPEEKING
            + "doVip!getCardById?";

    /**
     * 获取微帖列表
     */
    public static final String ACTION_GET_TRIBUNE_LIST = HOST_SPEEKING
            + "doTribune!listTribuneTyeByPage?";

    /**
     * 获取微帖回复列表
     */
    public static final String ACTION_GET_RE_TRIBUNE_LIST = HOST_SPEEKING
            + "doReTribune!listReTribuneTyeByPage?";

    /**
     * 微帖回复列表
     */
    public static final String ACTION_SAVERETRIBUENE = HOST_SPEEKING
            + "doReTribune!saveReTribuene?";

    /**
     * 注册
     */
    public static final String ACTION_REGISTER = HOST_SPEEKING
            + "doUser!saveUser?";

    /**
     * 发帖
     */
    public static final String ACTION_DOTRIBUNE = HOST_SPEEKING
            + "doTribune!saveTribune?";

    /**
     * 登录
     */
    public static final String ACTION_LOGIN = HOST_SPEEKING + "doUser!login?";

    /**
     * 添加会员卡
     */
    public static final String ACTION_ADDCARD_COUNT = HOST_SPEEKING
            + "pull!AddCard?";

    /**
     * 反馈意见
     */
    public static final String ACTION_FEEDBACK = HOST_SPEEKING
            + "pull!addFeedback?";

    /**
     * 添加优惠
     */
    public static final String ACTION_ADDDISCOUNT_COUNT = HOST_SPEEKING
            + "pull!AddDiscount?";

    /**
     * 添加分享
     */
    public static final String ACTION_SHAGE = HOST_SPEEKING + "pull!AddShare?";

    /**
     * 获取广告
     */
    public static final String ACTION_SHOWAD_IMAGE = HOST_SPEEKING
            + "Ad!ShowAdImageByType?";

    /**
     * 推送信息
     */
    public static final String ACTION_SHOWJPSHBYID = HOST_SPEEKING
            + "jp!showAd.action?id=";

    // private static final String UPGRADE_HD_URL
    // ="/MyVip/update/discountcard_update.xml";

    // 附近经纬度
    // http://192.168.120.12:8080/VipCard/doVip!listCardTyeByPage?page=1&cardType=0&cardClass=0&condition=2&distanceX=21.36&distanceY=110.632

    @Override
    public String getActionUrl(String action)
    {
        // TODO Auto-generated method stub
        if (ACTION_GET_DISCOUNT_LIST.equals(action))
        {
            return ACTION_GET_DISCOUNT_LIST;
        }
        if (ACTION_GET_TRIBUNE_LIST.equals(action))
        {
            return ACTION_GET_TRIBUNE_LIST;
        }
        if (ACTION_GET_RE_TRIBUNE_LIST.equals(action))
        {
            return ACTION_GET_RE_TRIBUNE_LIST;
        }
        if (ACTION_GET_CARD_TYPE_LIST.equals(action))
        {
            return ACTION_GET_CARD_TYPE_LIST;
        }
        if (ACTION_GET_BUSINESS_BY_ID_LIST.equals(action))
        {
            return ACTION_GET_BUSINESS_BY_ID_LIST;
        }
        if (ACTION_GET_CARD_CONTENT_LIST.equals(action))
        {
            return ACTION_GET_CARD_CONTENT_LIST;
        }
        if (ACTION_GET_DISCOUNT_LIST_DISID.equals(action))
        {
            return ACTION_GET_DISCOUNT_LIST_DISID;
        }
        if (ACTION_REGISTER.equals(action))
        {
            return ACTION_REGISTER;
        }
        if (ACTION_LOGIN.equals(action))
        {
            return ACTION_LOGIN;
        }
        if (ACTION_DOTRIBUNE.equals(action))
        {
            return ACTION_DOTRIBUNE;
        }
        if (ACTION_SAVERETRIBUENE.equals(action))
        {
            return ACTION_SAVERETRIBUENE;
        }
        if (ACTION_SEARCH_CARD_LIST.equals(action))
        {
            return ACTION_SEARCH_CARD_LIST;
        }
        if (ACTION_SEARCH_DISCOUNT_LIST.equals(action))
        {
            return ACTION_SEARCH_DISCOUNT_LIST;
        }
        if (ACTION_GET_DISCOUNT_BY_DISID.equals(action))
        {
            return ACTION_GET_DISCOUNT_BY_DISID;
        }
        if (ACTION_DO_VERIFY.equals(action))
        {
            return ACTION_DO_VERIFY;
        }
        if (ACTION_ADDCARD_COUNT.equals(action))
        {
            return ACTION_ADDCARD_COUNT;
        }
        if (ACTION_ADDDISCOUNT_COUNT.equals(action))
        {
            return ACTION_ADDDISCOUNT_COUNT;
        }
        if (ACTION_SHOWAD_IMAGE.equals(action))
        {
            return ACTION_SHOWAD_IMAGE;
        }
        if (ACTION_SHAGE.equals(action))
        {
            return ACTION_SHAGE;
        }
        if (ACTION_FEEDBACK.equals(action))
        {
            return ACTION_FEEDBACK;
        }
        return null;
    }
}
