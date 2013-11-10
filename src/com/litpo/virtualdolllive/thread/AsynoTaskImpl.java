package com.litpo.virtualdolllive.thread;

import com.litpo.virtualdolllive.DAO.WeatherDAO;
import com.litpo.virtualdolllive.pojos.Weather;
import com.litpo.virtualdolllive.util.Location;
import com.litpo.virtualdolllive.util.NetworkDetector;

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
