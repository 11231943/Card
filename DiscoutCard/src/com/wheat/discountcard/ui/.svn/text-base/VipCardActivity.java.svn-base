package com.wheat.discountcard.ui;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.view.View;
import cn.wheat.libs.bean.PageUtils;
import cn.wheat.libs.http.AsyncHttpRequest;
import cn.wheat.libs.http.AsyncLoadData;

import com.google.gson.reflect.TypeToken;
import com.wheat.discountcard.R;
import com.wheat.discountcard.bean.Card;
import com.wheat.discountcard.ui.base.BRBaseActivity;
import com.wheat.discountcard.utils.MAction;
import com.wheat.discountcard.utils.MContent;

/**
 * 会员卡首页
 * 
 * @author Administrator
 * @version XueXiBao v.1.3 2014-6-17
 * @since XueXiBao v.1.3
 */
public class VipCardActivity extends BRBaseActivity
{
    private List<Card> mBsList;
    /**
     * 页数
     */
    private int page = 1;
 
    private String condition = "0";
    @Override
    public void preCreate()
    {
        // TODO Auto-generated method stub
        super.preCreate();
        setTitleBarText(R.string.card_title);
    }

    @Override
    protected int setView()
    {
        // TODO Auto-generated method stub
        return R.layout.show_vip_main;
    }

    @Override
    protected void findViews()
    {
        // TODO Auto-generated method stub
        super.findViews();
        // mListView = (MMListView) findViewById(R.id.nc_class_list);
    }

    @Override
    protected void initEvent()
    {
        // TODO Auto-generated method stub
        super.initEvent();
        // mListView.setPullLoadEnable(true);
        // mListView.setListViewListener(listener);
    }

    @Override
    protected void loadData()
    {
        // TODO Auto-generated method stub
        super.loadData();
        getWorkData();
    }

    @Override
    public void onClick(View arg0)
    {
        // TODO Auto-generated method stub
    }

    /**
     * 获取会员卡列表 TODO method comment。
     * 
     */
    private void getWorkData()
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put(AsyncHttpRequest.REQUEST_ACTION,
                MAction.ACTION_GET_CARD_TYPE_LIST);
        params.put("cardClass", 0 + "");
        params.put("cardType", MContent.VIPCARD + "");
        params.put("condition", condition);
        // params.put("distanceX", MApplication.distanceX + "");
        // params.put("distanceY", MApplication.distanceY + "");
        params.put(MContent.PAGE, page + "");
        AsyncLoadData asyncLoadData = new AsyncLoadData(this, params,
                new AsyncLoadData.RequestCallback()
                {
                    @Override
                    public void success(Object data, int resultCode,
                            String msg, Object requestTag)
                    {
                        System.out
                                .println("----------------------" + data == null);
                        PageUtils pageUtils = (PageUtils) requestTag;
                        mBsList = (ArrayList<Card>) data;
                        if ((mBsList != null && !mBsList.isEmpty())
                                && pageUtils.getTotalRow() > 0)
                        {
                            System.out.println("mBsList ==" + mBsList);
//                            loadLocat(mBsList);
                        }
                        else
                        {

                        }
                    }

                    @Override
                    public void error(int errorType)
                    {
                        System.out.println("errorType =" + errorType);
                    }

                }, null, new AsyncLoadData.OnClickViewLoadDataListener()
                {

                    @Override
                    public void reload()
                    {
                        getWorkData();
                    }
                });
        Type type = new TypeToken<ArrayList<Card>>()
        {
        }.getType();
        asyncLoadData.setResultType(type);
        asyncLoadData.setResultType(AsyncHttpRequest.RESULT_DATA_TYPE_OBJECT);
        asyncLoadData.disableProgressDialog();
        asyncLoadData.disableToast();
        asyncLoadData.disableVerifyAction();
        asyncLoadData.execute();
    }
}
