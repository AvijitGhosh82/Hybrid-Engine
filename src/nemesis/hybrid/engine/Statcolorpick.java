package nemesis.hybrid.engine;


import com.larswerkman.colorpicker.ColorPicker;
import com.larswerkman.colorpicker.ColorPicker.OnColorChangedListener;
import com.larswerkman.colorpicker.OpacityBar;
import com.larswerkman.colorpicker.SVBar;
import nemesis.hybrid.engine.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

	public class Statcolorpick extends Activity implements OnColorChangedListener {
		 
		  private ColorPicker picker;
			private SVBar svBar;
			private OpacityBar opacityBar;
			private Button button;
			private TextView text;
			private SharedPreferences pref;
			private int color;
			private String png;
		 
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				pref = getSharedPreferences("avi", Context.MODE_WORLD_READABLE);
				picker = (ColorPicker) findViewById(R.id.picker);
				svBar = (SVBar) findViewById(R.id.svbar);
				opacityBar = (OpacityBar) findViewById(R.id.opacitybar);
				button = (Button) findViewById(R.id.button1);
				text = (TextView) findViewById(R.id.textView1);
				text.setText("Status Bar Color");
				
				picker.addSVBar(svBar);
				picker.addOpacityBar(opacityBar);
				picker.setOnColorChangedListener(this);
				
				button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						text.setTextColor(picker.getColor());
						picker.setOldCenterColor(picker.getColor());
						color=picker.getColor();
						startcolorchange();
						

					}
					
					

				});
				
	             
			}
			
			protected void startcolorchange() {
				
						SharedPreferences.Editor edit = pref.edit();
						edit.putInt("png",color);
						edit.commit();
						Intent send = new Intent();
						send.setAction("StatColorblast");
						sendBroadcast(send);

					}

			
			
		 
			@Override
			public void onColorChanged(int color) {
				//gives the color when it's changed.
			}
			
	}

