package com.wheat.discountcard.application;

/*
 * File Name：LSBApplication.java
 * Copyright：Copyright 2008-2013 CiWong.Inc. All Rights Reserved.
 * Description： LSBApplication.java
 * Modify By：PLA-ZJLIU
 * Modify Date：2013-12-5
 * Modify Type：Add
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.widget.Toast;
import cn.wheat.libs.application.DCApplication;
import cn.wheat.libs.http.AsyncHttpRequest;
import cn.wheat.libs.ui.BRLibsBaseActivity;
import cn.wheat.libs.utlis.CWSys;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.LocationData;
import com.baidu.mapapi.map.MKEvent;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationOverlay;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapCommonUtils;
import com.wheat.discountcard.R;
import com.wheat.discountcard.bean.UserInfo;
import com.wheat.discountcard.db.UserInfoDB;
import com.wheat.discountcard.utils.BitmapHelp;
import com.wheat.discountcard.utils.MAction;

/**
 * LSBApplication
 * 
 * @author Administrator
 * @version BlueRhion v.1.0 2014-3-24
 * @since BlueRhion v.1.0
 */
public class LSBApplication extends DCApplication
{

    private static LSBApplication mInstance = null;

    /**
     * 极光推送action
     */
    public static final String ALARMACTION = "cn.bluerhion.client.alarm";

    public boolean m_bKeyRight = true;

    public BMapManager mBMapManager = null;

    /**
     * 彭长坤 的百度ak
     */
    public static final String strKey = "3VOHofNuu7jzpH3pMlZN61m8";

    /**
     * 杨宇 的百度ak
     */
    // public static final String strKey = "aNF53LwUa8ixt4ArI9VvC635";

    /**
     * 定位相关
     */
    LocationClient mLocClient;

    LocationData locData = null;

    // 定位图层
    locationOverlay myLocationOverlay = null;

    boolean isFirstLoc = true;// 是否首次定位

    /**
     * 监听定位接口
     */
    public MyLocationListenner myListener = new MyLocationListenner();

    /**
     * 本机经纬度X
     */
    public static double distanceX;

    /**
     * 本机经纬度Y
     */
    public static double distanceY;

    private UserInfo info = null;

    private List<BRLibsBaseActivity> activities = null;

    /**
     * 城市数据库文件
     */
    public static File adFile = null;

    /**
     * 省市区 数据库 名
     */
    public static final String ADDRESS_DB = "address.db";

    public static BitmapUtils bitmapUtils;

    /**
     * 添加activty TODO method comment。
     * 
     * @param activity
     */
    public void addActivity(BRLibsBaseActivity activity)
    {
        if (activities == null)
        {
            activities = new ArrayList<BRLibsBaseActivity>();
        }
        activities.add(activity);
    }

    /**
     * 结束activity TODO method comment。
     * 
     */
    public void finshActivity()
    {
        if (activities != null)
        {
            for (BRLibsBaseActivity activity : activities)
            {
                activities.remove(activity);
                activity.finish();
                // activities = null;
            }
        }
    }

    /**
     * 获取用户信息 TODO method comment。
     * 
     * @return
     */
    public UserInfo getUserInfo()
    {
        // if (info == null)
        // {
        // int userid = CWSys.getSharedInt(getPackageName()
        // + LoginActivity.CACHE_USER_ID, 0);
        // if (userid != 0)
        // {
        // info = UserInfoDB.getUserInfo(userid);
        // }
        // }
        return info;
    }

    public void setUserInfo(UserInfo info)
    {
        this.info = info;
    }

    public static LSBApplication getInstance()
    {
        return mInstance;
    }

    /**
     * 获取 BMapManager对象 TODO method comment。
     * 
     * @return
     */
    public BMapManager getBMapManager()
    {
        if (mBMapManager == null)
        {
            mBMapManager = new BMapManager(getApplicationContext());
        }
        return mBMapManager;

    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        mInstance = this;
        AsyncHttpRequest.setRequestAction(new MAction());
        CWSys.setContext(this);
        UserInfoDB.setContext(this);
//        initEngineManager(this);
 //       initLocation();
//        /******** 极光推送 *********/
//        JPushInterface.setDebugMode(true); // 设置开启日志,发布时请关闭日志
//        JPushInterface.init(this); // 初始化 JPush
//        initBitmapUtilsConfig();
    }


    public BitmapUtils initBitmapUtilsConfig()
    {
        bitmapUtils = BitmapHelp.getBitmapUtils(this);
        bitmapUtils.configDefaultLoadingImage(R.drawable.ic_launcher);
        bitmapUtils.configDefaultLoadFailedImage(R.drawable.ic_launcher);
        bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);
        bitmapUtils.configMemoryCacheEnabled(true);
        // bitmapUtils.configDiskCacheEnabled(false);

        // bitmapUtils.configDefaultAutoRotation(true);

        // ScaleAnimation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
        // Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // animation.setDuration(800);

        // animation.setDuration(1000);
        // bitmapUtils.configDefaultImageLoadAnimation(animation);

        bitmapUtils.configDefaultBitmapMaxSize(BitmapCommonUtils.getScreenSize(
                this).scaleDown(3));
        return bitmapUtils;
    }

   

    /**
     * 定位初始化 TODO method comment。
     * 
     */
    private void initLocation()
    {
        mLocClient = new LocationClient(this);
        locData = new LocationData();
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);// 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        mLocClient.start();
    }

    /**
     * 初始化mBMapManager TODO method comment。
     * 
     * @param context
     */
    public void initEngineManager(Context context)
    {

        if (!getBMapManager().init(strKey, new MyGeneralListener()))
        {
            Toast.makeText(
                    LSBApplication.getInstance().getApplicationContext(),
                    "BMapManager  初始化错误!", Toast.LENGTH_LONG).show();
        }
    }

    // 常用事件监听，用来处理通常的网络错误，授权验证错误等
    public static class MyGeneralListener implements MKGeneralListener
    {

        @Override
        public void onGetNetworkState(int iError)
        {
            if (iError == MKEvent.ERROR_NETWORK_CONNECT)
            {
                Toast.makeText(
                        LSBApplication.getInstance().getApplicationContext(),
                        "您的网络出错啦！", Toast.LENGTH_LONG).show();
            }
            else if (iError == MKEvent.ERROR_NETWORK_DATA)
            {
                Toast.makeText(
                        LSBApplication.getInstance().getApplicationContext(),
                        "输入正确的检索条件！", Toast.LENGTH_LONG).show();
            }
            // ...
        }

        @Override
        public void onGetPermissionState(int iError)
        {
            // 非零值表示key验证未通过
            if (iError != 0)
            {
                // // 授权Key错误：
                Toast.makeText(
                        LSBApplication.getInstance().getApplicationContext(),
                        "请在 DemoApplication.java文件输入正确的授权Key,并检查您的网络连接是否正常！error: "
                                + iError, Toast.LENGTH_LONG).show();
                LSBApplication.getInstance().m_bKeyRight = false;
            }
            else
            {
                LSBApplication.getInstance().m_bKeyRight = true;
                Toast.makeText(
                        LSBApplication.getInstance().getApplicationContext(),
                        "key认证成功", Toast.LENGTH_LONG).show();
            }
        }
    }

    // 继承MyLocationOverlay重写dispatchTap实现点击处理
    public class locationOverlay extends MyLocationOverlay
    {

        public locationOverlay(MapView mapView)
        {
            super(mapView);
            // TODO Auto-generated constructor stub
        }

        @Override
        protected boolean dispatchTap()
        {
            // TODO Auto-generated method stub
            // 处理点击事件,弹出泡泡
            // popupText.setBackgroundResource(R.drawable.popup);
            // popupText.setText("我的位置");
            // pop.showPopup(BMapUtil.getBitmapFromView(popupText),
            // new GeoPoint((int)(locData.latitude*1e6),
            // (int)(locData.longitude*1e6)),
            // 8);
            return true;
        }
    }

    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener
    {

        @Override
        public void onReceiveLocation(BDLocation location)
        {
            if (location == null)
                return;

            locData.latitude = location.getLatitude();
            locData.longitude = location.getLongitude();
            // 如果不显示定位精度圈，将accuracy赋值为0即可
            locData.accuracy = location.getRadius();
            // 此处可以设置 locData的方向信息, 如果定位 SDK 未返回方向信息，用户可以自己实现罗盘功能添加方向信息。
            locData.direction = location.getDerect();
            distanceX = locData.latitude;
            distanceY = locData.longitude;
            System.out.println("distanceX " + distanceX + " distanceY="
                    + distanceY);
            mLocClient.stop();
            isFirstLoc = false;
        }

        public void onReceivePoi(BDLocation poiLocation)
        {
            if (poiLocation == null)
            {
                return;
            }
        }
    }

    /**
     * COPY文件 TODO method comment。
     * 
     * @param srcfilename
     *            文件名
     * @param file
     *            文件
     * @return
     */
    public boolean copyFile(String srcfilename, File file)
    {
        try
        {
            AssetManager am = getResources().getAssets();
            InputStream is = am.open(srcfilename);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1)
            {
                fos.write(buffer, 0, len);
            }
            fos.flush();
            fos.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}