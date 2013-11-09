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
			String city = "�Ϻ�";
			city = Location.getLocation();
			Weather weather = WeatherDAO.getWeather(city);
			weather.setCity(city);
			System.out.println("�¶�:" + weather.getTemperature());
			System.out.println("����:" + weather.getStatus());
			System.out.println("������:" + weather.getZwx());
			System.out.println("PM2.5:" + weather.getPm2_5());
			System.out.println("����:" + weather.getDirection1());
			System.out.println("������С:" + weather.getPower1());
			return weather;
		} else {
			return null;
		}
	}
}
