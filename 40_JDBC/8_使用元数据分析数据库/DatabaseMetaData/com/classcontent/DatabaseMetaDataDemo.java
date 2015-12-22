package DatabaseMetaData.com.classcontent;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import com.classcontent.util.DBUtil;

public class DatabaseMetaDataDemo {
	public static void main(String[] args) throws Exception {
		DBUtil dbUtil = new DBUtil();
		Connection con = dbUtil.getCon();
		// 获取元数据
		DatabaseMetaData dbMD = con.getMetaData();
		// 获取数据库名称
		System.out.println("数据库名称:" + dbMD.getDatabaseProductName());
		System.out.println("数据库版本号:" + dbMD.getDatabaseProductVersion());
		System.out.println("JDBC驱动主版本号:" + dbMD.getDatabaseMajorVersion());
		System.out.println("JDBC驱动次版本号:" + dbMD.getDatabaseMinorVersion());
	}
}
