package com.litpo.virtualdolllive.test;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.litpo.virtualdolllive.util.JsonParser;
import com.litpo.virtualdolllive.util.XmlParser;

public class Test {

	@org.junit.Test
	public void test() {
		String city = "上海";
		URL url;
		String link;
		try {
			// 获取新浪天气
			city = java.net.URLEncoder.encode(city, "gb2312");
			link = "http://php.weather.sina.com.cn/xml.php?city=" + city
					+ "&password=DJOYnieT8234jlsK&day=0";
			url = new URL(link);
			System.out.println(url);
			XmlParser parser = new XmlParser(url);
			String[] nodes = { "city", "status1", "status2", "temperature1",
					"temperature2" };
			Map<String, String> map = parser.getValue(nodes);

			// 获取PM2.5
			city = "上海";
			URI uri = URI.create(city);
//			link = "http://www.pm25.in/api/querys/pm2_5.json?city="
//					+ uri.toASCIIString()
//					+ "&token=5j1znBVAsnSf5xQyNQyq&stations=no";
			link="http://ddns.find1x.com/pm2_5.json";
			url = new URL(link);
			JsonParser jsonParser = new JsonParser();
			System.out.println(jsonParser.getConnection(url));
			HashMap<String, String> mapPollution = jsonParser.getPollution(url);
//			for (Map<String, String> mapPollution : list) {
//				System.out.println(mapPollution.toString());
//			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
