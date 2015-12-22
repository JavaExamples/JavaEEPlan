package ResultSetMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.classcontent.util.DBUtil;

public class ResultSetMetaDataDemo {
	public static void main(String[] args) throws Exception {
		DBUtil dbUtil = new DBUtil();
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSetMetaData rsmd = pstmt.getMetaData();
		int num = rsmd.getColumnCount(); // 获取元数据列总数
		System.out.println("共有:" + num + "列");
		for (int i = 1; i < num; i++) {
			System.out.println(rsmd.getColumnName(i) + "," + rsmd.getColumnTypeName(i));
		}
		dbUtil.closeAll(pstmt, con);
	}
}
