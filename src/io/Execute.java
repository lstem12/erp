package io;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Execute {

	public static void main(String[] args) {
		File path = new File("C:\\java_study\\address");
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (File file : files) {
				if (!file.isDirectory() && file.getName().indexOf("build_") == 0) {
					ReadText.readText(file.getName());
					//ReadText.dbInsert(addressList);					
					//List<Map<String,String>> phList = ReadText.parse(str);
					System.out.println("완료된 파일 :"+file.getName());

				}
			}
		}
		
		//System.out.println(phList);
	}
}
