package com.weifengzz.myvedioplayerdemo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class VideoImageView extends ImageView {
	private int mWidth = 0;// 宽度
	private int mHeight = 0;// 高度

	public VideoImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public VideoImageView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public VideoImageView(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		// 设置宽度
		int specMode = MeasureSpec.getMode(widthMeasureSpec);
		int specSize = MeasureSpec.getSize(widthMeasureSpec);

		if (specMode == MeasureSpec.EXACTLY)// 如果是match_parent
		{
			mWidth = specSize;
		} else {
			// 由图片决定的宽
			int sWidth = specSize / 10;
			if (specMode == MeasureSpec.AT_MOST)// 如果是wrap_content
			{
				mWidth = sWidth;
			}
		}
		setMeasuredDimension(mWidth, mWidth);
	}
}
