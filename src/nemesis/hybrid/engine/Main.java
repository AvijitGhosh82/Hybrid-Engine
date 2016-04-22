package nemesis.hybrid.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.actionbarsherlock.app.SherlockActivity;

import nemesis.hybrid.engine.R;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends SherlockActivity {
	private Button btn,btn2,btn3,btn4,btn5,btn6;
	private SharedPreferences pref;
	private String png;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button) findViewById(R.id.stat);
		btn.setOnClickListener(new OnClickListener() {

			public void onClick(View vag) {
				Intent intent = new Intent(Main.this, Statcolorpick.class);
				Main.this.startActivity(intent);
				

			}
		});
		btn2 = (Button) findViewById(R.id.tile);
		btn2.setOnClickListener(new OnClickListener() {

			public void onClick(View vag) {
				Intent intent = new Intent(Main.this, Tilecolorpick.class);
				Main.this.startActivity(intent);
				

			}
		});
		btn3 = (Button) findViewById(R.id.tiletext);
		btn3.setOnClickListener(new OnClickListener() {

			public void onClick(View vag) {
				Intent intent = new Intent(Main.this, Tiletextcolorpick.class);
				Main.this.startActivity(intent);
				

			}
		});
		btn4 = (Button) findViewById(R.id.clock);
		btn4.setOnClickListener(new OnClickListener() {

			public void onClick(View vag) {
				Intent intent = new Intent(Main.this,Clockcolorpick.class);
				Main.this.startActivity(intent);
				

			}
		});
		btn5 = (Button) findViewById(R.id.panel);
		btn5.setOnClickListener(new OnClickListener() {

			public void onClick(View vag) {
				Intent intent = new Intent(Main.this, Panelcolorpick.class);
				Main.this.startActivity(intent);
				

			}
		});
		
		btn6 = (Button) findViewById(R.id.clocktext);
		btn6.setOnClickListener(new OnClickListener() {

			public void onClick(View vag) {
				Intent intent = new Intent(Main.this, Clocktextcolorpick.class);
				Main.this.startActivity(intent);
				

			}
		});

	}


}

