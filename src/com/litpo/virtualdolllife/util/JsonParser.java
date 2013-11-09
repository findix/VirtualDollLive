package com.litpo.virtualdolllife.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonParser {

	public String getConnection(URL url) {
		String data = "PM2.5";
		try {
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
			data = stringbu.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		data = data.substring(2, data.length() - 1);// 换成官方服务器的时候一定要把2改成1！！
		return data;
	}

	public HashMap<String, String> getPollution(URL path) {
		HashMap<String, String> map = null;
		try {
			// 调用getConnection()获得数据流
			String json = getConnection(path);
			if (json != null) {
				// 对象的形式
				JSONTokener jsonTokener = new JSONTokener(json);
				JSONObject item = (JSONObject) jsonTokener.nextValue();
				// 得到对象中的对象
				String pm2_5 = item.getString("pm2_5");
				String pm2_5_24h = item.getString("pm2_5_24h");
				String quality = item.getString("quality");
				// 添加到map中
				map = new HashMap<String, String>();
				map.put("pm2_5", pm2_5);
				map.put("pm2_5_24h", pm2_5_24h);
				map.put("quality", quality);
			} else {
				System.out.println("获取流数据失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
