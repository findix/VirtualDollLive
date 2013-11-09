package com.litpo.virtualdolllife.thread;

import com.litpo.virtualdolllife.DAO.WeatherDAO;
import com.litpo.virtualdolllife.pojos.Weather;
import com.litpo.virtualdolllife.util.Location;
import com.litpo.virtualdolllife.util.NetworkDetector;

import android.content.Context;
import android.os.AsyncTask;

public class AsynoTaskImpl extends AsyncTask<Context, Object, Weather> {

	@Override
	protected Weather doInBackground(Context... context) {
		if (NetworkDetector.detect(context[0])) {
			String city = "上海";
			city = Location.getLocation();
			Weather weather = WeatherDAO.getWeather(city);
			weather.setCity(city);
			System.out.println("温度:" + weather.getTemperature());
			System.out.println("天气:" + weather.getStatus());
			System.out.println("紫外线:" + weather.getZwx());
			System.out.println("PM2.5:" + weather.getPm2_5());
			System.out.println("风向:" + weather.getDirection1());
			System.out.println("风力大小:" + weather.getPower1());
			return weather;
		} else {
			return null;
		}
	}
}
