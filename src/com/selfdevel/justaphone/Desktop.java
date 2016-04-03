package com.selfdevel.justaphone;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class Desktop extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		disableStatusBar();
		setContentView(R.layout.activity_desktop);
	}

	private void disableStatusBar() {
		WindowManager manager = ((WindowManager) getApplicationContext()
				.getSystemService(Context.WINDOW_SERVICE));

		WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
		localLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
		localLayoutParams.gravity = Gravity.TOP;
		localLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
				|

				// this is to enable the notification to recieve touch events
				WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |

				// Draws over status bar
				WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

		localLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
		localLayoutParams.height = (int) (50 * getResources()
				.getDisplayMetrics().scaledDensity);
		localLayoutParams.format = PixelFormat.TRANSPARENT;

		customViewGroup view = new customViewGroup(this);

		manager.addView(view, localLayoutParams);

		// disable the status bar, but disables all elements in screen
		// getWindow().addFlags(WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY);
	}

	public void openSettings(View v) {
		startActivityForResult(new Intent(
				android.provider.Settings.ACTION_SETTINGS), 0);
	}

	public class customViewGroup extends ViewGroup {

		public customViewGroup(Context context) {
			super(context);
		}

		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
		}

		@Override
		public boolean onInterceptTouchEvent(MotionEvent ev) {
			Log.v("customViewGroup", "**********Intercepted");
			return true;
		}
	}

	public void onWindowFocusChanged(boolean hasFocus) {

	}

}
