/*
 * File Name��TPBaseFragment.java
 * Copyright��Copyright 2014-2014 XueXiBao. All Rights Reserved.
 * Description�� TPBaseFragment.java
 * Modify By��Administrator
 * Modify Date��2014-6-16
 * Modify Type��Add
 */
package com.wheat.discountcard.ui.base;

import android.os.Bundle;
import android.widget.Button;
import cn.wheat.libs.widget.MarqueeTextView;

import com.wheat.discountcard.fragment.HomeFragment;
import com.wheat.discountcard.ui.MainActivity;

/**
 * 
 * @author     Administrator
 * @version    XueXiBao v.1.3 2014-6-16
 * @since      XueXiBao v.1.3
 */
public class TPBaseFragment  extends LSBBaseFragment 
{
    
    public final static int DEF_GO_BACK = -1;

    private Button menuTitle;

    protected MarqueeTextView titleMenu;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }
    
    @Override
    public void onResume()
    {
        super.onResume();
    }
    
    
    
    public MainActivity getMainActivity()
    {
        return (MainActivity) getActivity();
    }

    
     
    public void showHomeFragment(Bundle data, boolean isClear)
    {
        HomeFragment homeFragment = new HomeFragment();
        getMainActivity().setSlideContent(homeFragment, isClear);
    }

    public void showChatFragment(Bundle data)
    {
        showHomeFragment(data, true);
    }

    @Override
    public int setView()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void preCreate()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void findViews()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void init()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void initEvent()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void loadData()
    {
        // TODO Auto-generated method stub
        
    }
}
