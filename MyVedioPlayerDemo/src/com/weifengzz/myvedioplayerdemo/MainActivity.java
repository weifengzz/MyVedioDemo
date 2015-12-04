package com.weifengzz.myvedioplayerdemo;

import com.weifengzz.myvedioplayerdemo.player.Player;
import com.weifengzz.myvedioplayerdemo.views.VideoSeekBar;
import com.weifengzz.myvedioplayerdemo.views.VideoSurfaceView;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	private ImageView playImg = null;// 播放状态图标
	private ImageView screenImg = null;// 全屏图标
	private SeekBar videoSeekBar = null;// seekbar
	private VideoSurfaceView surfaceView = null;// surfaceview
	private Player player = null;// player 类

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	/**
	 * 初始化控件
	 * */
	private void initView() {
		playImg = (ImageView) findViewById(R.id.vi_img01);
		screenImg = (ImageView) findViewById(R.id.vi_img02);
		videoSeekBar = (SeekBar) findViewById(R.id.vsb_seekbar);
		surfaceView = (VideoSurfaceView) findViewById(R.id.vs_view);
		player = new Player(surfaceView, videoSeekBar);
		videoSeekBar.setOnSeekBarChangeListener(new SeekBarChangeEvent());
		// 播放按钮响应的事件
		playImg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String url = "http://mp4.28mtv.com/mp41/39227-%E4%BB%BB%E8%B4%A4%E9%BD%90-%E6%98%A5%E5%A4%A9%E8%8A%B1%E4%BC%9A%E5%BC%80%5B68mtv.com%5D.mp4";
				player.playUrl(url);
			}
		});
		// 全屏的响应事件
		screenImg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
					setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				}
			}
		});
		// surfaceView的相应事件
		surfaceView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	class SeekBarChangeEvent implements OnSeekBarChangeListener {
		int progress;

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// 原本是(progress/seekBar.getMax())*player.mediaPlayer.getDuration()
			this.progress = progress * player.mediaPlayer.getDuration()
					/ seekBar.getMax();
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// seekTo()的参数是相对与影片时间的数字，而不是与seekBar.getMax()相对的数字
			player.mediaPlayer.seekTo(progress);
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}
}
