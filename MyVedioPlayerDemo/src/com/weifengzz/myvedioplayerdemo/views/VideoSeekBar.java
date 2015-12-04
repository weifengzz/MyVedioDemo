package com.weifengzz.myvedioplayerdemo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class VideoSeekBar extends SeekBar {
	private int mWidth = 0;
	private int mHeight = 0;

	public VideoSeekBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public VideoSeekBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public VideoSeekBar(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected synchronized void onMeasure(int widthMeasureSpec,
			int heightMeasureSpec) {
		// TODO Auto-generated method stub
		// 设置宽度
		int specMode = MeasureSpec.getMode(widthMeasureSpec);
		int specSize = MeasureSpec.getSize(widthMeasureSpec);
		int sWidth = specSize ;
		if (specMode == MeasureSpec.EXACTLY)// 如果是match_parent
		{
			mWidth = specSize;
		} else {
			// 由图片决定的宽
			if (specMode == MeasureSpec.AT_MOST)// 如果是wrap_content
			{
				mWidth = sWidth;
			}
		}
		/**
		 * 设置高度
		 */
		specMode = MeasureSpec.getMode(heightMeasureSpec);
		int shpecSize = MeasureSpec.getSize(heightMeasureSpec);
		if (specMode == MeasureSpec.EXACTLY)// 如果是match_parent
		{
			mHeight = shpecSize;
		} else {
			mHeight = sWidth / 9;
		}
		setMeasuredDimension(mWidth, mHeight);
	}
}
