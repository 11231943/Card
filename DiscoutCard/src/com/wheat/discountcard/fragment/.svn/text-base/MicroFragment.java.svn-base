package com.wheat.discountcard.fragment;

import java.util.ArrayList;
import java.util.List;

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
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.ViewFlipper;

import com.wheat.discountcard.R;
import com.wheat.discountcard.apdater.TabMicroAdapter;
import com.wheat.discountcard.bean.Micro;
import com.wheat.discountcard.ui.base.TPBaseFragment;
import com.wheat.discountcard.ui.widget.LogoScrollView;
import com.wheat.discountcard.ui.widget.MricoGridView;

/**
 * @author Administrator
 * @version XueXiBao v.1.3 2014-6-16
 * @since XueXiBao v.1.3
 */
public class MicroFragment extends TPBaseFragment implements OnGestureListener,
        OnTouchListener
{

    private ViewFlipper viewFlipper;

    private GestureDetector mGestureDetector;

    private boolean showNext = true;

    private boolean isRun = true;

    private int currentPage = 0;

    private final int SHOW_NEXT = 0011;

    private static final int FLING_MIN_DISTANCE = 50;

    private static final int FLING_MIN_VELOCITY = 0;

    MricoGridView view;

    private List<Micro> micros;

    private int[] imgs = new int[]{R.drawable.wtt1, R.drawable.wtt2,
            R.drawable.wtt3, R.drawable.wtt4, R.drawable.wtt5, R.drawable.wtt6,
            R.drawable.wtt7, R.drawable.wtt8};

    private TabMicroAdapter adapter;

    private ScrollView myScrollView = null;

    @Override
    public int setView()
    {
        // TODO Auto-generated method stub
        return R.layout.micro_frame;
    }

    @Override
    public void findViews()
    {
        // TODO Auto-generated method stub
        super.findViews();

        view = (MricoGridView) findViewById(R.id.mygrid);
        viewFlipper = (ViewFlipper) findViewById(R.id.mViewFliper_vf);

    }

    @Override
    public void initEvent()
    {
        super.initEvent();
        setMicroData();
        adapter = new TabMicroAdapter(getActivity(), micros);
        view.setAdapter(adapter);
        mGestureDetector = new GestureDetector(this);
        viewFlipper.setOnTouchListener(this);
        viewFlipper.setLongClickable(true);
        viewFlipper.setOnClickListener(clickListener);
        LogoScrollView myScrollView = (LogoScrollView) findViewById(R.id.viewflipper_scrollview);
        myScrollView.setOnTouchListener(onTouchListener);
        myScrollView.setGestureDetector(mGestureDetector);
        myScrollView.requestChildFocus(viewFlipper, null);
        thread.start();
    }

    @Override
    public void loadData()
    {
        // TODO Auto-generated method stub
        super.loadData();
    }

    /**
     * 设置微帖 TODO method comment。
     * 
     */
    public void setMicroData()
    {
        micros = new ArrayList<Micro>();
        String[] titles = getResources().getStringArray(R.array.micro_list);
        String[] micro_list_content = getResources().getStringArray(
                R.array.micro_list_content);
        for (int i = 0; i < titles.length; i++)
        {
            Micro micro = new Micro();
            micro.setId(i);
            micro.setmTitle(titles[i]);
            micro.setImgs(imgs[i]);
            micro.setmTitleContent(micro_list_content[i]);
            micros.add(micro);
        }
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

        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getActivity(),
                R.anim.push_left_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getActivity(),
                R.anim.push_left_out));
        viewFlipper.showNext();
        currentPage++;
        if (currentPage == viewFlipper.getChildCount())
        {
            displayRatio_normal(currentPage - 1);
            currentPage = 0;
            displayRatio_selelct(currentPage);
        }
        else
        {
            displayRatio_selelct(currentPage);
            displayRatio_normal(currentPage - 1);
        }
        Log.e("currentPage", currentPage + "");

    }

    private void showPreviousView()
    {
        displayRatio_selelct(currentPage);
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getActivity(),
                R.anim.push_right_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getActivity(),
                R.anim.push_right_out));
        viewFlipper.showPrevious();
        currentPage--;
        if (currentPage == -1)
        {
            displayRatio_normal(currentPage + 1);
            currentPage = viewFlipper.getChildCount() - 1;
            // displayRatio_selelct(currentPage);
        }
        else
        {
            displayRatio_selelct(currentPage);
            displayRatio_normal(currentPage + 1);
        }
        Log.e("currentPage", currentPage + "");
    }

    private void displayRatio_selelct(int id)
    {
        int[] ratioId = {R.id.home_ratio_img_04, R.id.home_ratio_img_03,
                R.id.home_ratio_img_02, R.id.home_ratio_img_01};
        ImageView img = (ImageView) findViewById(ratioId[id]);
        img.setSelected(true);
    }

    private void displayRatio_normal(int id)
    {
        int[] ratioId = {R.id.home_ratio_img_04, R.id.home_ratio_img_03,
                R.id.home_ratio_img_02, R.id.home_ratio_img_01};
        ImageView img = (ImageView) findViewById(ratioId[id]);
        img.setSelected(false);
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
            float arg3)
    {

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
        showNext =false;
        isRun = false;
        thread = null;
    }
}
