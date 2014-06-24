/*
 * File Name：MricoGridView.java
 * Copyright：Copyright 2014-2014 XueXiBao. All Rights Reserved.
 * Description： MricoGridView.java
 * Modify By：Administrator
 * Modify Date：2014-6-21
 * Modify Type：Add
 */
package com.wheat.discountcard.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

/**
 * TODO Description of class。
 * <p>
 * TODO Detail Description
 * <p>
 * TODO Sample Code
 * <pre>
 * </pre>
 * 
 * @author     Administrator
 * @version    XueXiBao v.1.3 2014-6-21
 * @since      XueXiBao v.1.3
 */
public class MricoGridView extends GridView { 
    public MricoGridView(Context context, AttributeSet attrs) { 
        super(context, attrs); 
    } 

    public MricoGridView(Context context) { 
        super(context); 
    } 

    public MricoGridView(Context context, AttributeSet attrs, int defStyle) { 
        super(context, attrs, defStyle); 
    } 

    @Override 
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { 

        int expandSpec = MeasureSpec.makeMeasureSpec( 
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST); 
        super.onMeasure(widthMeasureSpec, expandSpec); 
    } 
}
