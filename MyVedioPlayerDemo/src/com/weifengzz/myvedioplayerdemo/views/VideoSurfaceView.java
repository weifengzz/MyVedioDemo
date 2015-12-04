package com.weifengzz.myvedioplayerdemo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * 自定义surfaceview类
 * 
 * @author WFZ
 * */
public class VideoSurfaceView extends SurfaceView {
	private int mHeight = 0;// 控件的高度
	private int mWidth = 0;// 控件的宽度

	public VideoSurfaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public VideoSurfaceView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public VideoSurfaceView(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 设置SurfaceView的宽高
	 * */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		//设置宽度
		int specSize = MeasureSpec.getSize(widthMeasureSpec);
		mWidth = specSize;
		//设置高度
		mHeight = (int) (mWidth*0.6);// 设置高度为宽度的1.5倍
		setMeasuredDimension(mWidth, mHeight);
	}
	
}
