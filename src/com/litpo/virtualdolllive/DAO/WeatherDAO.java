package com.litpo.virtualdolllive.DAO;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.litpo.virtualdolllive.pojos.Weather;
import com.litpo.virtualdolllive.util.JsonParser;
import com.litpo.virtualdolllive.util.XmlParser;

public class WeatherDAO {
	public static Weather getWeather(String city) {
		Weather weather = new Weather();
		weather.setCity(city);
		URL url;
		String link;
		try {
			// 获取新浪天气
			link = "http://php.weather.sina.com.cn/xml.php?city="
					+ java.net.URLEncoder.encode(city, "gb2312")
					+ "&password=DJOYnieT8234jlsK&day=0";
			// System.out.println(link);
			url = new URL(link);
			XmlParser parser = new XmlParser(url);
			String[] nodes = { "city", "status1", "status2", "temperature1",
					"temperature2", "zwx", "direction1", "direction2",
					"power1", "power2" };
			Map<String, String> map = parser.getValue(nodes);

			weather.setTemperature1(map.get("temperature1").toString());
			weather.setTemperature2(map.get("temperature2").toString());
			weather.setStatus1(map.get("status1").toString());
			weather.setStatus2(map.get("status2").toString());
			weather.setZwx(map.get("zwx").toString());
			weather.setDirection1(map.get("direction1").toString());
			weather.setDirection2(map.get("direction2").toString());
			weather.setPower1(map.get("power1").toString());
			weather.setPower2(map.get("power2").toString());

			// 获取PM2.5
			URI uri = URI.create(city);
			link = "http://www.pm25.in/api/querys/pm2_5.json?city="
					+ uri.toASCIIString()
					+ "&token=Wmj9yCvPaARVVkzqGp73&stations=no";
			// link = "http://ddns.find1x.com/pm2_5.json";
			url = new URL(link);
			JsonParser jsonParser = new JsonParser();
			HashMap<String, String> mapPollution = jsonParser.getPollution(url);
			if (!mapPollution.isEmpty()) {
				weather.setPm2_5(mapPollution.get("pm2_5").toString());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return weather;
	}
}
