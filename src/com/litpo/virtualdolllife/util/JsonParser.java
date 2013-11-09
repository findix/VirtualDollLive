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
			// ʹ��HttpURLConnection������
			HttpURLConnection urlConn = (HttpURLConnection) url
					.openConnection();

			// �õ���ȡ������(��)
			InputStreamReader in = new InputStreamReader(
					urlConn.getInputStream(), Charset.forName("utf-8"));

			// Ϊ�������BufferedReader
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
		data = data.substring(2, data.length() - 1);// ���ɹٷ���������ʱ��һ��Ҫ��2�ĳ�1����
		return data;
	}

	public HashMap<String, String> getPollution(URL path) {
		HashMap<String, String> map = null;
		try {
			// ����getConnection()���������
			String json = getConnection(path);
			if (json != null) {
				// �������ʽ
				JSONTokener jsonTokener = new JSONTokener(json);
				JSONObject item = (JSONObject) jsonTokener.nextValue();
				// �õ������еĶ���
				String pm2_5 = item.getString("pm2_5");
				String pm2_5_24h = item.getString("pm2_5_24h");
				String quality = item.getString("quality");
				// ��ӵ�map��
				map = new HashMap<String, String>();
				map.put("pm2_5", pm2_5);
				map.put("pm2_5_24h", pm2_5_24h);
				map.put("quality", quality);
			} else {
				System.out.println("��ȡ������ʧ��!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
