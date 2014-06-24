package com.wheat.discountcard.ui;

import android.view.View;
import android.widget.TextView;
import cn.wheat.libs.utlis.CWSys;

import com.wheat.discountcard.R;
import com.wheat.discountcard.ui.base.BRBaseActivity;

 
public class AboutActivity extends BRBaseActivity {
    
    
    
	private TextView versionName;

	@Override
	public void preCreate()
	{
	    // TODO Auto-generated method stub
	    setTitleBarText("关于我们");
	    super.preCreate();
	}
	@Override
	protected int setView() {
		// TODO Auto-generated method stub
		return R.layout.activity_about;
	}

	@Override
	protected void findViews() {
		super.findViews();
		versionName = (TextView) findViewById(R.id.versionName);
	}

	@Override
	protected void initEvent() {
		super.initEvent();
		versionName.setText("版本 : v"+CWSys.getSystemVersion(this));
		// TODO Auto-generated method stub
	}

	@Override
	protected void loadData() {
		// TODO Auto-generated method stub
		super.loadData();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
