package address;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Execute {
	public static String[] rKey() {
		String keyStr = "DONG_CODE\r\n" + "SIDO_NAME\r\n" + "GUGUN_NAME\r\n" + "DONG_NAME\r\n" + "LEE_NAME\r\n"
				+ "IS_MNT\r\n" + "JIBUN_BONBUN\r\n" + "JIBUN_SUBBUN\r\n" + "ROAD_CODE\r\n" + "UNDER_CHECK\r\n"
				+ "BON_NUMBER\r\n" + "SUB_NUMBER\r\n" + "AREA_NUMBER";
		String[] keys = keyStr.split("\r\n");
		return keys;
	}
	public static void main(String[] args) {
		
		ReadTextJibun readTextJibun = new ReadTextJibun();
		InsertJibun insertJibun = new InsertJibun();
		File path = new File("C:\\java-study\\address");
		String[] keys = rKey();
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			System.out.println("-시작-");
			for (File file : files) {
				if (!file.isDirectory() && file.getName().indexOf("jibun_jeju") == 0) {
					List<Map<String, String>> jibunList = readTextJibun.readText1(file,keys);
					insertJibun.dbInsert(jibunList,keys);
					System.out.println("완료된 파일 :" + file.getName());
				}
			}
			System.out.println("-끝-");
		}

	}
}