package com.wheat.discountcard.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.wheat.discountcard.R;
import com.wheat.discountcard.apdater.TabGirdAdapter;
import com.wheat.discountcard.ui.VipCardActivity;
import com.wheat.discountcard.ui.base.TPBaseFragment;
import com.wheat.discountcard.ui.widget.LogoScrollView;

/**
 * 
 * @author Administrator
 * @version XueXiBao v.1.3 2014-6-16
 * @since XueXiBao v.1.3
 */
public class HomeFragment extends TPBaseFragment implements OnGestureListener,
        OnTouchListener
{
    private RelativeLayout home_itme_layou_near;

    private RelativeLayout home_itme_layou_card;

    private RelativeLayout home_itme_layou_volume;

    private RelativeLayout home_itme_layou_free;

    private ViewFlipper viewFlipper;

    private GestureDetector mGestureDetector;

    private boolean showNext = true;

    private boolean isRun = true;

    private int currentPage = 0;

    private final int SHOW_NEXT = 0011;

    private static final int FLING_MIN_DISTANCE = 50;

    private static final int FLING_MIN_VELOCITY = 0;

    private GridView gridView;

    private TabGirdAdapter girdAdapter;

    private LinearLayout city_layou;

    private int[] img = new int[]{R.drawable.maidanglao, R.drawable.kdj,
            R.drawable.cuiyuan, R.drawable.xianglemen};

    @Override
    public int setView()
    {
        // TODO Auto-generated method stub
        return R.layout.home_frame;
    }

    @Override
    public void findViews()
    {
        // TODO Auto-generated method stub
        super.findViews();
        home_itme_layou_near = (RelativeLayout) findViewById(R.id.home_itme_layou_near);
        home_itme_layou_card = (RelativeLayout) findViewById(R.id.home_itme_layou_card);
        home_itme_layou_volume = (RelativeLayout) findViewById(R.id.home_itme_layou_volume);
        home_itme_layou_free = (RelativeLayout) findViewById(R.id.home_itme_layou_free);
        city_layou = (LinearLayout) findViewById(R.id.city_layou);
        viewFlipper = (ViewFlipper) findViewById(R.id.mViewFliper_vf);
        gridView = (GridView) findViewById(R.id.home_gridview);
    }

    @Override
    public void init()
    {
        // TODO Auto-generated method stub
        super.init();
    }

    @Override
    public void initEvent()
    {
        // TODO Auto-generated method stub
        super.initEvent();
        city_layou.setVisibility(View.VISIBLE);
        home_itme_layou_near.setOnClickListener(this);
        home_itme_layou_card.setOnClickListener(this);
        home_itme_layou_volume.setOnClickListener(this);
        home_itme_layou_free.setOnClickListener(this);
        mGestureDetector = new GestureDetector(this);
        viewFlipper.setOnTouchListener(this);
        viewFlipper.setLongClickable(true);
        viewFlipper.setOnClickListener(clickListener);
        LogoScrollView myScrollView = (LogoScrollView) findViewById(R.id.viewflipper_scrollview);
        myScrollView.setOnTouchListener(onTouchListener);
        myScrollView.setGestureDetector(mGestureDetector);
        thread.start();

        girdAdapter = new TabGirdAdapter(getActivity(), img);
        gridView.setAdapter(girdAdapter);
    }

    private OnClickListener clickListener = new OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            // TODO Auto-generated method stub
            System.out.println("------+ " + currentPage);
        }
    };

    private OnTouchListener onTouchListener = new OnTouchListener()
    {

        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
            // TODO Auto-generated method stub
            return mGestureDetector.onTouchEvent(event);
        }
    };

    Handler mHandler = new Handler()
    {

        @Override
        public void handleMessage(Message msg)
        {
            // TODO Auto-generated method stub
            switch (msg.what)
            {
                case SHOW_NEXT:
                    if (showNext)
                    {
                        showNextView();
                    }
                    else
                    {
                        showPreviousView();
                    }
                    break;

                default:
                    break;
            }
        }

    };

    Thread thread = new Thread()
    {

        @Override
        public void run()
        {
            // TODO Auto-generated method stub
            while (isRun)
            {
                try
                {
                    Thread.sleep(1000 * 4);
                    Message msg = new Message();
                    msg.what = SHOW_NEXT;
                    mHandler.sendMessage(msg);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    };

    private void showNextView()
    {
        if (viewFlipper != null)
        {
            viewFlipper.setInAnimation(AnimationUtils.loadAnimation(
                    getActivity(), R.anim.push_left_in));
            viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(
                    getActivity(), R.anim.push_left_out));
            viewFlipper.showNext();
            currentPage++;
            if (currentPage == viewFlipper.getChildCount())
            {
                // displayRatio_normal(currentPage - 1);
                currentPage = 0;
                // displayRatio_selelct(currentPage);
            }
            else
            {
                // displayRatio_selelct(currentPage);
                // displayRatio_normal(currentPage - 1);
            }
            Log.e("currentPage", currentPage + "");
        }

    }

    private void showPreviousView()
    {
        if (viewFlipper != null)
        {
            // displayRatio_selelct(currentPage);
            viewFlipper.setInAnimation(AnimationUtils.loadAnimation(
                    getActivity(), R.anim.push_right_in));
            viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(
                    getActivity(), R.anim.push_right_out));
            viewFlipper.showPrevious();
            currentPage--;
            if (currentPage == -1)
            {
                // displayRatio_normal(currentPage + 1);
                currentPage = viewFlipper.getChildCount() - 1;
                // displayRatio_selelct(currentPage);
            }
            else
            {
                // displayRatio_selelct(currentPage);
                // displayRatio_normal(currentPage + 1);
            }
            Log.e("currentPage", currentPage + "");
        }
    }

    @Override
    public void loadData()
    {
        // TODO Auto-generated method stub
        super.loadData();
    }

    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        Intent intent = null;
        switch (v.getId())
        {
            case R.id.home_itme_layou_card:
                intent = new Intent(getActivity(), VipCardActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public boolean onTouch(View arg0, MotionEvent event)
    {
        // TODO Auto-generated method stub
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
            float velocityY)
    {
        // TODO Auto-generated method stub

        Log.e("view", "onFling");
        if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY)
        {
            Log.e("fling", "left");
            showNextView();
            showNext = true;
            // return true;
        }
        else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY)
        {
            Log.e("fling", "right");
            showPreviousView();
            showNext = false;
            // return true;
        }

        return false;
    }

    @Override
    public void onLongPress(MotionEvent arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
            float arg3)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onPause()
    {
        // TODO Auto-generated method stub
        super.onPause();
        isRun = false;
    }

    @Override
    public void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
        isRun = true;
    }

    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
        showNext = false;
        isRun = false;
        thread = null;
    }
}
