package com.classcontent;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.classcontent.util.DBUtil;

/*
存储过程
DELIMITER |
CREATE PROCEDURE pro_getBookNameById(IN bookId INT, OUT bN VARCHAR(20))
BEGIN
SELECT bookName INTO bN FROM t_book WHERE id = bookId;
END
|
DELIMITER ;
 */

public class CallableStatementDemo {
	private static DBUtil dbUtil = new DBUtil();
	
	/**
	 * 调用存储过程, 通过id查询bookName
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private static String getBookNameById(int id) throws Exception {
		Connection con = dbUtil.getCon();
		String sql = "{CALL pro_getBookNameById(?,?)}";
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, id);
		cstmt.registerOutParameter(2, Types.VARCHAR); // 设置返回值类型
		cstmt.execute();
		String bookName = cstmt.getString("bN"); // 获取返回值
		dbUtil.closeAll(cstmt, con);
		return bookName;
	}
	
	public static void main(String[] args) throws Exception {
		String bookName = getBookNameById(10);
		System.out.println(bookName);
	}
}
