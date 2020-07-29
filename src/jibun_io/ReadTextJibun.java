package jibun_io;

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

public class ReadTextJibun {
	public List<Map<String,String>> readText1(File f) {
		List<Map<String, String>> list = new ArrayList<>();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		String str = "";
		String keyStr = "DONG_CODE\r\n" + "SIDO_NAME\r\n" + "GUGUN_NAME\r\n" + "DONG_NAME\r\n" + "LEE_NAME\r\n"
				+ "IS_MNT\r\n" + "JIBUN_BONBUN\r\n" + "JIBUN_SUBBUN\r\n" + "ROAD_CODE\r\n" + "UNDER_CHECK\r\n"
				+ "BON_NUMBER\r\n" + "SUB_NUMBER\r\n" + "AREA_NUMBER";
		String keys[] = keyStr.split("\r\n");
		try {
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis, "MS949");
			br = new BufferedReader(isr);
			sb = new StringBuffer();
			while((str = br.readLine())!=null) {
				String[] values = str.split("\\|");
				Map<String, String> map = new HashMap<>();
				for(int j=0; j<keys.length;j++) {
					map.put(keys[j], values[j]);
				}
				list.add(map);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
