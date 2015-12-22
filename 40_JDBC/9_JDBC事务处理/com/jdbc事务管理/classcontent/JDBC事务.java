package com.jdbc事务管理.classcontent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;

import com.classcontent.util.DBUtil;

public class JDBC事务 {
	private static DBUtil dbUtil = new DBUtil();
	
	/**
	 * 转出金额
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void outCount(Connection con, String accountName, int account) throws Exception {
		String sql = "update t_account set accountBalance = accountBalance - ? where accountName = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, account);
		pstmt.setString(2, accountName);
		pstmt.executeUpdate();
	}
	
	/**
	 * 转入金额
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void inCount(Connection con, String accountName, int account) throws Exception {
		String sql = "update t_account set account = accountBalance+? where accountName=?"; // set accountBalance 故意改错, 为测试事务
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, account);
		pstmt.setString(2, accountName);
		int result = pstmt.executeUpdate();
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		Connection con = null;
		Savepoint sp = null;
		try {
			con = dbUtil.getCon();
			con.setAutoCommit(false);// 取消自动提交
			System.out.println("张三向李四转账");
			int account = 1000;
			outCount(con, "a", account);
			sp = con.setSavepoint(); // 设置保存点(此处无法确保a的账户在转账不成功的时候不扣钱)
			inCount(con, "b", account);
			System.out.println("转账成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				System.out.println("余额不足将会回滚操作");
				con.rollback(sp);
				System.out.println("回滚成功");
			} catch (Exception e2) {
				// TODO: handle exception
			}
			e.printStackTrace();
		} finally {
			try {
				con.commit();// 提交事务
				dbUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
