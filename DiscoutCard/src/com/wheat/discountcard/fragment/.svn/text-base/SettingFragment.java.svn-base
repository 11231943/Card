package com.wheat.discountcard.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import cn.wheat.libs.utlis.CWUpdate;
import cn.wheat.libs.widget.CWToast;

import com.wheat.discountcard.R;
import com.wheat.discountcard.ui.AboutActivity;
import com.wheat.discountcard.ui.DimensionAcitivty;
import com.wheat.discountcard.ui.FeedbackActivity;
import com.wheat.discountcard.ui.ServiceActivity;
import com.wheat.discountcard.ui.base.TPBaseFragment;
import com.wheat.discountcard.utils.MAction;

/**
 * 
 * @author Administrator
 * @version XueXiBao v.1.3 2014-6-16
 * @since XueXiBao v.1.3
 */
public class SettingFragment extends TPBaseFragment {

	 
	private RelativeLayout dimension_layou;
	 
	private RelativeLayout clean_cache;
	 
	private RelativeLayout detail_share_dark;
 
	private RelativeLayout feedback_layou;
	 
	private RelativeLayout update_layou;
 
	private RelativeLayout about;

	@Override
	public int setView() {
		return R.layout.setting_frame;
	}

	@Override
	public void findViews() {
		super.findViews();
		dimension_layou = (RelativeLayout) findViewById(R.id.dimension_layou);
		clean_cache = (RelativeLayout) findViewById(R.id.clean_cache);
		detail_share_dark = (RelativeLayout) findViewById(R.id.detail_share_dark);
		feedback_layou = (RelativeLayout) findViewById(R.id.feedback_layou);
		update_layou = (RelativeLayout) findViewById(R.id.update_layou);
		about = (RelativeLayout) findViewById(R.id.about);
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void initEvent() {
		super.initEvent();
		dimension_layou.setOnClickListener(this);
		clean_cache.setOnClickListener(this);
		detail_share_dark.setOnClickListener(this);
		feedback_layou.setOnClickListener(this);
		update_layou.setOnClickListener(this);
		about.setOnClickListener(this);
	}

	@Override
	public void loadData() {
		super.loadData();
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		Intent intent = null;
		switch (v.getId()) {
		case R.id.dimension_layou:
			intent = new Intent(getActivity(), DimensionAcitivty.class);
			break;
		case R.id.clean_cache:
			cleanCache();
			break;
		case R.id.detail_share_dark:
			share(intent);
			break;
		case R.id.feedback_layou:
			intent = new Intent(getActivity(), FeedbackActivity.class);
			break;
		case R.id.update_layou:
			update();
			break;
		case R.id.about:
			intent = new Intent(getActivity(), AboutActivity.class);
			break;
		}
		startActivity(intent,DEF_GO_BACK);
	}

 
	private void update() {
		CWToast.centerCorrect(getActivity(), "正在更新中请稍后...").show();
		CWUpdate mUpdate = new CWUpdate(getActivity(), MAction.UPGRADE_HD_URL,
				new CWUpdate.Callback() {
					/**
					 * {@inheritDoc}
					 */
					@Override
					public void excuteSelfMethod() {
						super.excuteSelfMethod();
					}
				});
		mUpdate.excute(false);//  
	}

	 
	private void share(Intent intent) {
		// TODO Auto-generated method stub
		// long userId = CWSys.getSharedLong(getActivity().getPackageName()
		// + "_USER_ID", 0);
		// if (userId != 0) {
		// UserInfo mUserInfo = UserInfoDB.getUserinfo(userId);
		// try {
		// shareToWechat(mUserInfo);
		//
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		// }
		// } else {
		// intent = new Intent(getActivity(), LoginActivity.class);
		// intent.putExtra("USER_ID", userId);
		// startActivity(intent);
		// }
	}

	 
	private void cleanCache() {
		// TODO Auto-generated method stub
		// ImageLoader.getInstance().clearDiscCache();
		// ImageLoader.getInstance().clearMemoryCache();
		// CWToast.centerCorrect(this, "����ɹ�...").show();
	}
}
