package com.litpo.virtualdolllive;

import com.litpo.virtualdolllive.R;
import com.litpo.virtualdolllive.pojos.Weather;
import com.litpo.virtualdolllive.thread.AsyncTaskImpl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView text_weather;
	Button btn_getWeather;
	ProgressBar progressBar;

	Weather weather;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text_weather = (TextView) findViewById(R.id.text_weather);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		btn_getWeather = (Button) findViewById(R.id.btn_getWeather);
		btn_getWeather.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AsyncTaskImpl asynoTaskImpl = new AsyncTaskImpl(
						MainActivity.this, progressBar, text_weather);
				asynoTaskImpl.execute(MainActivity.this);
			}
		});
		AsyncTaskImpl asynoTaskImpl = new AsyncTaskImpl(
				MainActivity.this, progressBar, text_weather);
		asynoTaskImpl.execute(MainActivity.this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
