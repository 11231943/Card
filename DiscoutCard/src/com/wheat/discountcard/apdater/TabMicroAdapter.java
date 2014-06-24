package com.wheat.discountcard.apdater;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wheat.discountcard.R;
import com.wheat.discountcard.bean.Micro;

/**
 * 微帖首页GridView适配器
 * 
 * @author Administrator
 * 
 */
public class TabMicroAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Micro> mList;

    public TabMicroAdapter(Context context, List<Micro> micros) {
	this.mContext = context;
	this.mInflater = LayoutInflater.from(context);
	this.mList = micros;
    }

    @Override
    public int getCount() {
	return mList.size();
    }

    @Override
    public Object getItem(int position) {
	return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
	return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
	final ViewHolder mViewHolder;
	if (convertView == null) {
	    mViewHolder = new ViewHolder();
	    convertView = mInflater.inflate(R.layout.grid_tools, null);
	    mViewHolder.mImageView = (ImageView) convertView .findViewById(R.id.id_area_img);
	    mViewHolder.textView = (TextView) convertView .findViewById(R.id.id_area);
	    mViewHolder.id_area_count= (TextView) convertView .findViewById(R.id.id_area_count);
	    convertView.setTag(mViewHolder);
	} else {
	    mViewHolder = (ViewHolder) convertView.getTag();
	}
	mViewHolder.mImageView.setImageResource(mList.get(position).getImgs());
	mViewHolder.textView.setText(mList.get(position).getmTitle());
	mViewHolder.id_area_count.setText(mList.get(position).getmTitleContent());
	return convertView;
    }

    static class ViewHolder {

	public ImageView mImageView;

	private TextView textView ,id_area_count;
    }
}