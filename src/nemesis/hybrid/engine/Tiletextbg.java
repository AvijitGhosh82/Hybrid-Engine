package nemesis.hybrid.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class Tiletextbg extends ImageView {
	private Context context;
	private boolean mAttached;

	public Tiletextbg(Context context) {
		super(context);
		this.context = context;

	}

	public Tiletextbg(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();

		if (!mAttached) {
			mAttached = true;
			IntentFilter filter = new IntentFilter();
			filter.addAction("TiletextColorblast");
			getContext().registerReceiver(mIntentReceiver, filter, null,
					getHandler());
		}

		updateCarrier();

	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		if (mAttached) {
			getContext().unregisterReceiver(mIntentReceiver);
			mAttached = false;
		}
	}

	private final BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals("TiletextColorblast")) {
				updateCarrier();

			}
		}
	};

	@SuppressWarnings("deprecation")
	protected void updateCarrier() {
		Context c = null;
		try {
			c = context.createPackageContext("nemesis.hybrid.engine", 0);
		} catch (NameNotFoundException e) {	}
		SharedPreferences p = c.getSharedPreferences("avi", context.MODE_WORLD_READABLE);	
		if(p.contains("Tiletextpng")){
			setBackgroundColor(p.getInt("Tiletextpng", 17170443));
		}
		
		p=null;
	}

}

