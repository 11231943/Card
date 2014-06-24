package com.wheat.discountcard.ui;

import java.io.UnsupportedEncodingException;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wheat.discountcard.R;
import com.wheat.discountcard.bean.UserInfo;
import com.wheat.discountcard.ui.base.BRBaseActivity;

public class LoginActivity extends BRBaseActivity {
	/**
	 */
	public static final String CACHE_USER_ID = "_USER_ID";

	private EditText user_p, pwd;

	private Button login_but;

	private TextView register;

	private UserInfo userinfo;

	private ImageView search_but, back_image = null;

	private TextView jump_bis;

	@Override
	protected int setView() {
		// TODO Auto-generated method stub
		return R.layout.activity_login;
	}

	@Override
	protected void findViews() {
		super.findViews();
		user_p = (EditText) findViewById(R.id.user_p);
		pwd = (EditText) findViewById(R.id.pwd);
		back_image.setVisibility(View.VISIBLE);
		login_but = (Button) findViewById(R.id.login_but);
		register = (TextView) findViewById(R.id.register);
		search_but = (ImageView) findViewById(R.id.search_but);
		search_but.setVisibility(View.GONE);
		jump_bis = (TextView) findViewById(R.id.jump_bis);
	}

	@Override
	protected void initEvent() {
		super.initEvent();
		jump_bis.setOnClickListener(this);
		back_image.setOnClickListener(this);
		register.setOnClickListener(this);
		login_but.setOnClickListener(this);
	}

	@Override
	protected void loadData() {
		// TODO Auto-generated method stub
		super.loadData();
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.jump_bis:
			// TODO Auto-generated method stub
			Intent intentService = new Intent(LoginActivity.this,
					ServiceActivity.class);
			startActivity(intentService);
			break;
	 
		case R.id.register:
			Intent intentRegister = new Intent(LoginActivity.this,
					RegisterActivity.class);
			startActivityForResult(intentRegister, 100);
			break;
		case R.id.login_but:
		// try {
		// login();
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// hideSoftInput(v);
			break;
		}

	}

	/**
	 * ��¼
	 * 
	 * @throws UnsupportedEncodingException
	 * 
	 */
	// private void login() throws UnsupportedEncodingException {
	// if (user_p.getText().toString().length() < 1) {
	// return;
	// }
	// if (pwd.getText().toString().length() < 1) {
	// return;
	// }
	// Map<String, String> params = new HashMap<String, String>();
	// params.put("phone", user_p.getText().toString());
	// params.put("pwd", pwd.getText().toString());
	// params.put(AsyncHttpRequest.REQUEST_ACTION, MAction.ACTION_LOGIN);
	// AsyncLoadData asyncLoadData = new AsyncLoadData(
	// this,
	// params,
	// new AsyncLoadData.RequestCallback() {
	// @Override
	// public void success(Object data, int resultCode, String msg) {
	// if (data != null) {
	// final UserInfo userinfo = (UserInfo) data;
	// System.out.println("msg =" + msg + "list ="
	// + userinfo);
	// CWToast.centerSquareCorrect(LoginActivity.this,
	// "��¼�ɹ�!").show();
	// setUserInfo(userinfo);
	// if (userinfo != null) {
	// CWSys.setSharedLong(getPackageName()
	// + CACHE_USER_ID, userinfo.getId());
	// UserInfoDB.addUserinfo(userinfo);
	// setResult(1000);
	// finish();
	// }
	// } else {
	// CWToast.centerSquareCorrect(LoginActivity.this, msg)
	// .show();
	// }
	//
	// }
	//
	// @Override
	// public void success(String result) {
	// // TODO Auto-generated method stub
	// System.out.println("result =" + result);
	// }
	//
	// @Override
	// public void error(int errorType) {
	// System.out.println("errorType =" + errorType);
	// CWToast.centerSquareCorrect(LoginActivity.this,
	// "��¼ʧ��! ").show();
	// }
	//
	// }, AsyncLoadData.REQUEST_POST, null,
	// new AsyncLoadData.OnClickViewLoadDataListener() {
	//
	// @Override
	// public void reload() {
	//
	// }
	// });
	// Type type = new TypeToken<Userinfo>() {
	// }.getType();
	// asyncLoadData.setResultType(type);
	// asyncLoadData.setResultType(AsyncHttpRequest.RESULT_DATA_TYPE_OBJECT);
	// asyncLoadData.disableProgressDialog();
	// asyncLoadData.disableToast();
	// asyncLoadData.disableVerifyAction();
	// asyncLoadData.execute();
	// }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		// System.out.println("���������������" + requestCode);
		// switch (resultCode) { // resultCodeΪ�ش��ı�ǣ�����B�лش�����RESULT_OK
		// case 100:
		// if (data.getSerializableExtra(MContent.OBJECT_KEY_USER) != null) {
		// userinfo = (Userinfo) data
		// .getSerializableExtra(MContent.OBJECT_KEY_USER);
		// user_p.setText(userinfo.getPhone());
		// pwd.setText(userinfo.getPwd());
		// }
		// break;
		// }
	}

	/**
	 * ע���
	 * 
	 * @param callBack
	 */
	// public static void registrationSkinCallBack(LoginCallBack callBack) {
	// if (!callBackList.contains(callBack)) {
	// callBackList.add(callBack);
	// }
	// }

	/**
	 * �Ƴ����
	 * 
	 * @param callBack
	 */
	// public static void removeSkinCallBack(LoginCallBack callBack) {
	// callBackList.remove(callBack);
	// }
	//
	// protected interface LoginCallBack {
	// void callback();
	// }

	/**
	 * �Ƴ�ȫ������
	 * 
	 * @param callBack
	 */
	// public static void clearSkinCallBack() {
	// if (callBackList != null && !callBackList.isEmpty()) {
	// callBackList.clear();
	// }
	// }
}
