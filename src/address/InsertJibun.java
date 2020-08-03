package address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Conn;



public class InsertJibun {

	public void dbInsert(List<Map<String,String>> jibunList,String[] keys) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into jibun_address(";
			String value = " values(";
			for (String key : keys) {
				sql += key + ",";
				value += "?,";
			}
			sql = sql.substring(0, sql.length() - 1) + ")";
			value = value.substring(0, value.length() - 1) + ")";
			sql += value;
			con = Conn.open();
			ps = con.prepareStatement(sql);
			int cnt=1;
			for (Map<String, String> row : jibunList) {
				for (int i = 0; i < keys.length; i++) {
					ps.setString((i + 1), row.get(keys[i]));
				}
				ps.addBatch();
				if(cnt%1000==0) {
					ps.executeBatch();
					ps.clearBatch();
				}
				cnt++;
			}
			if(jibunList.size()%1000!=0) {
				ps.executeBatch();
				ps.clearBatch();				
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conn.close(ps,con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
}