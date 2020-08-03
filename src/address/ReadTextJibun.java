package address;

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
	public List<Map<String,String>> readText1(File f,String[] keys) {
		List<Map<String, String>> list = new ArrayList<>();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String str = "";	
		try {
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis, "MS949");
			br = new BufferedReader(isr);
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
		} finally {
			try {
				if(br !=null) {
					br.close();
				}
				if(isr !=null) {
					isr.close();
				}
				if(fis !=null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}