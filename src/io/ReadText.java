package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadText {

	public static String readText(String path) {
		File f = new File(path);
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str + "\r\n");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Map<String, String>> parse(String str) {
		String[] strs = str.split("\\|");
		String key = "DONG_CODE\r\n" + 
				"SIDO\r\n" + 
				"GUGUN\r\n" + 
				"DONG_NAME\r\n" + 
				"LEE_NAME\r\n" + 
				"IS_MNT\r\n" + 
				"JIBUN\r\n" + 
				"SUB_JIBUN\r\n" + 
				"RODA_CODE\r\n" + 
				"ROAD_NAME\r\n" + 
				"IS_BASE\r\n" + 
				"BUILD_NUM\r\n" + 
				"SUB_BUILD_NUM\r\n" + 
				"BUILDING_NAME\r\n" + 
				"DETAIL_BUILDING_NAME\r\n" + 
				"ADDR_CODE";
		String[] keys = key.split("\r\n");
		List<Map<String, String>> list = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			if (i == 0) {
				keys = keys[i].split("\r\n");
			} else {
				String[] values = strs[i].split("\\|");
				Map<String, String> map = new HashMap<>();
				if (keys.length == values.length) {
					for (int idx = 0; idx < keys.length; idx++) {
						map.put(keys[idx], values[idx]);
					}
				}
				list.add(map);
			}
		}
		return list;
	}
}
