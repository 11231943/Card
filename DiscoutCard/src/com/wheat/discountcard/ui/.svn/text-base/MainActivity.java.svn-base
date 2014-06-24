package com.wheat.discountcard.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import cn.wheat.libs.widget.IndicateText;

import com.wheat.discountcard.R;
import com.wheat.discountcard.application.LSBApplication;
import com.wheat.discountcard.fragment.HomeFragment;
import com.wheat.discountcard.fragment.MicroFragment;
import com.wheat.discountcard.fragment.MyInfoFragment;
import com.wheat.discountcard.fragment.SettingFragment;
import com.wheat.discountcard.ui.base.BRBaseActivity;
import com.wheat.discountcard.ui.base.TPBaseFragment;

public class MainActivity extends BRBaseActivity implements
        OnCheckedChangeListener
{

    private RadioGroup radioMenu;// �˵�

    public RadioButton home, micro, info, setting;// �˵�ѡ��

    private HomeFragment homeFragment;

    private MicroFragment microFragment;

    private MyInfoFragment infoFragment;

    private SettingFragment settingFragment;

    private int curSelectRadioId;// ��ǰ����˵�ID

    private ViewGroup content;// ����

    private TPBaseFragment curInfoFragment;// Fragment���ࣺ�����ʾ
    
    
    private IndicateText msgCount;// δ����Ϣ

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setView()
    {
        // TODO Auto-generated method stub
        return R.layout.activity_main;
    }

    @Override
    protected void findViews()
    {
        // TODO Auto-generated method stub
        super.findViews();
        radioMenu = (RadioGroup) findViewById(R.id.radioMenu);
        home = (RadioButton) findViewById(R.id.home);
        micro = (RadioButton) findViewById(R.id.micro);
        info = (RadioButton) findViewById(R.id.info);
        setting = (RadioButton) findViewById(R.id.setting);
        content = (ViewGroup) findViewById(R.id.continer);
        msgCount = (IndicateText) findViewById(R.id.msgCount);
    }

    @Override
    protected void initEvent()
    {
        super.initEvent();
        // TODO Auto-generated method stub
        radioMenu.setOnCheckedChangeListener(this);
        home.setChecked(true);
        msgCount.getViewTreeObserver().addOnGlobalLayoutListener(
                new OnGlobalLayoutListener()
                {

                    @Override
                    public void onGlobalLayout()
                    {
                        locateMsgCount(msgCount.getMeasuredWidth());
                        msgCount.getViewTreeObserver()
                                .removeGlobalOnLayoutListener(this);
                    }
                });
    }

    
   /**
    * 显示小红点
    * TODO method comment。
    * @param w
    */
    private void locateMsgCount(int w)
    {
        final int l, t;
        View view = radioMenu.getChildAt(3);
        final int iw = w;
        final int rw = view.getLeft();
        RadioGroup.LayoutParams viewLP = (RadioGroup.LayoutParams) view
                .getLayoutParams();
        l = rw - iw + radioMenu.getLeft() ;
        t = viewLP.topMargin +2;
        LayoutParams lp = (LayoutParams) msgCount.getLayoutParams();
        lp.gravity = Gravity.TOP;
        lp.setMargins(l, t, 0, 0);
        msgCount.setLayoutParams(lp);
    }

    @Override
    protected void init()
    {
        // TODO Auto-generated method stub
        super.init();
    }

    @Override
    protected void loadData()
    {
        // TODO Auto-generated method stub
        super.loadData();
    }

    /**
     * 
     * 设置显示当前Fragment
     * 
     * @param fragment
     *            {@link Fragment}
     */
    public void setSlideContent(TPBaseFragment fragment)
    {
        setSlideContent(fragment, true);
    }

    public void setSlideContent(TPBaseFragment fragment, boolean isClear)
    {
        if (fragment == null)
        {
            return;
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (ft == null)
        {
            return;
        }
        ft.replace(R.id.continer, fragment);
        ft.commitAllowingStateLoss();

    }

    @Override
    public void onCheckedChanged(RadioGroup arg0, int checkedId)
    {
        // TODO Auto-generated method stub
        TPBaseFragment fragment = null;
        Intent intent = null;
        String id = "";
        boolean showInfoContainer = false;
        switch (checkedId)
        {
            case R.id.home:
                if (this.homeFragment == null)
                {
                    this.homeFragment = new HomeFragment();
                }
                fragment = this.homeFragment;
                id = String.valueOf(R.id.home);
                showInfoContainer = true;
                break;
            case R.id.micro:
                if (this.microFragment == null)
                {
                    this.microFragment = new MicroFragment();
                }
                fragment = this.microFragment;
                id = String.valueOf(R.id.micro);
                showInfoContainer = true;
                break;
            case R.id.info:
                if (this.infoFragment == null)
                {
                    this.infoFragment = new MyInfoFragment();
                }
                fragment = this.infoFragment;
                id = String.valueOf(R.id.info);
                showInfoContainer = true;
                break;
            case R.id.setting:
                if (this.settingFragment == null)
                {
                    this.settingFragment = new SettingFragment();
                }
                fragment = this.settingFragment;
                id = String.valueOf(R.id.setting);
        }
        curSelectRadioId = checkedId;
        setActivityGroupContent(showInfoContainer, fragment, intent, id);

    }

    /**
     * 启动 Fragment
     * 
     * @param showInfoContainer
     * @param fragment
     * @param intent
     * @param id
     */
    public void setActivityGroupContent(boolean showInfoContainer,
            TPBaseFragment fragment, Intent intent, String id)
    {
        if (fragment != null)
        {
            setShowContent(fragment, id);
        }
        else
        {
            hideFragment(curInfoFragment);
            curInfoFragment = null;
        }
    }
    /**
     * 隐藏Fragment
     * 
     * @param fragment
     */
    public void hideFragment(TPBaseFragment fragment)
    {
        if (fragment == null)
        {
            return;
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (ft == null)
        {
            return;
        }
        ft.hide(fragment);
        ft.commitAllowingStateLoss();
    }
    

    /**
     * 显示Content内容
     * 
     * @param fragment
     * @param tag
     */
    public void setShowContent(TPBaseFragment fragment, String tag)
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (ft == null)
        {
            return;
        }
        TPBaseFragment mTPBaseFragment = (TPBaseFragment) fm
                .findFragmentByTag(tag);
        if (mTPBaseFragment == null)
        {
            ft.add(R.id.continer, fragment, tag);
        }
        else
        {
            ft.show(mTPBaseFragment);
        }
        if (curInfoFragment != null && curInfoFragment != fragment)
        {
            ft.hide(curInfoFragment);
        }
        curInfoFragment = fragment;
        ft.commitAllowingStateLoss();
    }


    @Override
    public void onClick(View arg0)
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    protected void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
        LSBApplication.getInstance().exit(true);
        
    }

}
