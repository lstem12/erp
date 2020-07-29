package jibun_io;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Execute {
	public static void main(String[] args) {
		ReadTextJibun readTextJibun = new ReadTextJibun();
		InsertJibun insertJibun = new InsertJibun();
		File path = new File("C:\\java_study\\address");
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (File file : files) {
				if (!file.isDirectory() && file.getName().indexOf("jibun_") == 0) {
					if(file.getName().equals("jibun_jeju.txt")) {
					List<Map<String,String>> jibunList = readTextJibun.readText1(file);
					insertJibun.dbInsert(jibunList);
					// List<Map<String,String>> phList = ReadText.parse(str);
					System.out.println("완료된 파일 :" + file.getName());
					System.out.println(jibunList);
					}

				}
			}
		}

	}
}
