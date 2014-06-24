package com.wheat.discountcard.ui;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import cn.wheat.libs.http.AsyncHttpRequest;
import cn.wheat.libs.http.AsyncLoadData;
import cn.wheat.libs.widget.CWToast;

import com.google.gson.reflect.TypeToken;
import com.wheat.discountcard.R;
import com.wheat.discountcard.bean.Feedback;
import com.wheat.discountcard.ui.base.BRBaseActivity;
import com.wheat.discountcard.utils.MAction;

public class FeedbackActivity extends BRBaseActivity {
    @Override
    public void preCreate()
    {
        // TODO Auto-generated method stub
        setTitleBarText("关于我们");
        super.preCreate();
    }
	private RelativeLayout rl_feedback;
 
	private EditText et_get_suggestion;

	@Override
	protected int setView() {
		// TODO Auto-generated method stub
		return R.layout.activity_feedback;
	}

	@Override
	protected void findViews() {
		super.findViews();
		rl_feedback = (RelativeLayout) findViewById(R.id.rl_feedback);
		et_get_suggestion = (EditText) findViewById(R.id.et_get_suggestion);
	}

	@Override
	protected void initEvent() {
		super.initEvent();

		rl_feedback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (et_get_suggestion.getText().length() < 1) {
					CWToast.error(FeedbackActivity.this, "总要说点什么吧~亲").show();
					return;
				}
				try {
					doSub();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
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

	/**
	 *提交反馈
	 * @throws UnsupportedEncodingException
	 */
	public void doSub() throws UnsupportedEncodingException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("str", URLEncoder.encode(et_get_suggestion.getText()
				.toString(), "utf-8"));
		params.put(AsyncHttpRequest.REQUEST_ACTION, MAction.ACTION_FEEDBACK);
		AsyncLoadData asyncLoadData = new AsyncLoadData(
				this,
				params,
				new AsyncLoadData.RequestCallback() {
					@Override
					public void success(Object data, int resultCode, String msg) {
						System.out.println("resultCode =" + resultCode);
					}

					@Override
					public void error(int errorType) {
						System.out.println("errorType =" + errorType);
						CWToast.centerCorrect(FeedbackActivity.this,
								"提交失败").show();
						finish();
					}

				}, AsyncLoadData.REQUEST_POST, null,
				new AsyncLoadData.OnClickViewLoadDataListener() {

					@Override
					public void reload() {

					}
				});
		Type type = new TypeToken<Feedback>() {
		}.getType();
		asyncLoadData.setResultType(type);
		asyncLoadData.setResultType(AsyncHttpRequest.RESULT_DATA_TYPE_OBJECT);
		asyncLoadData.disableProgressDialog();
		asyncLoadData.disableToast();
		asyncLoadData.disableVerifyAction();
		asyncLoadData.execute();
	}
}
