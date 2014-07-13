package com.litpo.virtualdolllive.thread;

import com.litpo.virtualdolllive.DAO.WeatherDAO;
import com.litpo.virtualdolllive.calendar.CalendarGetter;
import com.litpo.virtualdolllive.pojos.Weather;
import com.litpo.virtualdolllive.util.Location;
import com.litpo.virtualdolllive.util.NetworkDetector;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncTaskImpl extends AsyncTask<Object, Object, Weather> {
	ProgressBar progressBar;
	Context context;
	TextView text_weather;

	public AsyncTaskImpl(Context context, ProgressBar progressBar,
			TextView text_weather) {
		this.context = context;
		this.progressBar = progressBar;
		this.text_weather = text_weather;
	}

	@Override
	protected void onPreExecute() {
		progressBar.setVisibility(View.VISIBLE);
		super.onPreExecute();
	}

	@Override
	protected Weather doInBackground(Object... params) {
		if (NetworkDetector.detect(context)) {
			String city = Location.getLocation();
			Weather weather = WeatherDAO.getWeather(city);
			weather.setCity(city);
			return weather;
		} else {
			return null;
		}
	}

	@Override
	protected void onPostExecute(Weather weather) {
		if (weather != null) {
			progressBar.setVisibility(View.INVISIBLE);
			String weatherString = "当前位置："+weather.getCity()
					+ "\n温度:"
					+ weather.getTemperature2()
					+ " ~ "
					+ weather.getTemperature1()
					+ "℃\n天气:"
					+ weather.getStatus1()
					+ (weather.getStatus1().equals(weather.getStatus2()) ? ""
							: ("转" + weather.getStatus2()))
					+ "\n紫外线:"
					+ weather.getZwx()
					+ "\nPM2.5:"
					+ weather.getPm2_5()
					+ "\n风向:"
					+ weather.getDirection1()
					+ (weather.getDirection1().equals(weather.getDirection2()) ? ""
							: (" 转 " + weather.getDirection2())) + "\n风力大小:"
					+ weather.getPower1() + "级" + "\n今日事项:"
					+ CalendarGetter.isBusy(context);
			text_weather.setText(weatherString);
		} else {
			progressBar.setVisibility(View.INVISIBLE);
			text_weather.setText("网络异常");
		}
		super.onPostExecute(weather);
	}
}
