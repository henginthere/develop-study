package com.ssafy.day02.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTestDrive {
	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/empdept?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");

			String query = "select * from emp where ename=?";
			String deleteQuery = "delete from emp where empno=?";
			String insertQuery = "insert into emp values(?,?,?,?,?,?,?,?)";
			String createQuery = "create table test( "
									+ "id int primary key, "
									+ "name varchar(20) not null, "
									+ "addr varchar(40) )";

			pstmt = conn.prepareStatement(createQuery);
			pstmt.executeUpdate();
			pstmt.close();

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "SMITH");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("empno") + " " + rs.getString("ename"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (conn != null) { conn.close(); }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
