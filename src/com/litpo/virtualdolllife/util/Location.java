package com.litpo.virtualdolllife.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Location {
	public static String getLocation() {
		String link = "http://api.map.baidu.com/location/ip?ak=0B69fb64214bb730badbb2e2135052cb";
		String city = null;
		try {
			URL url = new URL(link);
			// 使用HttpURLConnection打开连接
			HttpURLConnection urlConn = (HttpURLConnection) url
					.openConnection();

			// 得到读取的内容(流)
			InputStreamReader in = new InputStreamReader(
					urlConn.getInputStream(), Charset.forName("utf-8"));

			// 为输出创建BufferedReader
			BufferedReader bufReader = new BufferedReader(in);

			String line = "";
			StringBuilder stringbu = new StringBuilder();
			while ((line = bufReader.readLine()) != null) {
				stringbu.append(line);
			}
			String json = stringbu.toString();
			JSONTokener jsonTokener = new JSONTokener(json);
			JSONObject item = (JSONObject) jsonTokener.nextValue();
			city=item.getJSONObject("content").getJSONObject("address_detail").getString("city");
			if(city.charAt(city.length()-1)=='市'){
				city=city.substring(0, city.length()-1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return city;
	}
}
