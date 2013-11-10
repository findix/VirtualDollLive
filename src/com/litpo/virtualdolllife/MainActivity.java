package com.litpo.virtualdolllife;

import java.util.concurrent.ExecutionException;

import com.litpo.virtualdolllife.calendar.CalendarGetter;
import com.litpo.virtualdolllife.pojos.Weather;
import com.litpo.virtualdolllife.thread.AsynoTaskImpl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView text_weather;
	Button btn_getWeather;

	Weather weather;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text_weather = (TextView) findViewById(R.id.text_weather);
		btn_getWeather = (Button) findViewById(R.id.btn_getWeather);
		btn_getWeather.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println(CalendarGetter.isBusy(MainActivity.this));
				AsynoTaskImpl asynoTaskImpl = new AsynoTaskImpl();
				asynoTaskImpl.execute(MainActivity.this);
				try {
					weather = asynoTaskImpl.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (weather != null) {
					String weatherString = "��ǰ����:" + weather.getCity()
							+ "\n�¶�:" + weather.getTemperature() + "\n����:"
							+ weather.getStatus() + "\n������:" + weather.getZwx()
							+ "\nPM2.5:" + weather.getPm2_5() + "\n����:"
							+ weather.getDirection1() + "\n������С:"
							+ weather.getPower1() + "\n����æ��æ:"
							+ CalendarGetter.isBusy(MainActivity.this);
					text_weather.setText(weatherString);
				} else {
					text_weather.setText("�����쳣");
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
