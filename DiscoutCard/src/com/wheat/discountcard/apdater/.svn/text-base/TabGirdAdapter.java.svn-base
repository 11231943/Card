package com.wheat.discountcard.apdater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.wheat.discountcard.R;

/**
 * @author PLA-ZJLIU
 * @version ciwong v.1.0 2012-12-29
 * @since ciwong v.1.0
 */
public class TabGirdAdapter extends BaseAdapter
{
    private int img[] = null;

    private LayoutInflater mInflater;

    public TabGirdAdapter(Context context, int[] img)
    {
        this.img = img;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return img == null ? 0 : img.length;
    }

    @Override
    public Object getItem(int position)
    {
        return img == null ? null : img[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewHolder mViewHolder;
        if (convertView == null)
        {
            mViewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.tab_gird_item, null);
            mViewHolder.mImageView = (ImageView) convertView
                    .findViewById(R.id.hoem_grid_image);
            convertView.setTag(mViewHolder);
        }
        else
        {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mImageView.setImageResource(img[position]);
        return convertView;
    }

    static class ViewHolder
    {

        public ImageView mImageView, select_img;
    }
}
