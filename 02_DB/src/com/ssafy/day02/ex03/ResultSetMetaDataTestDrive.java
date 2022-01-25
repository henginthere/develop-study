package com.ssafy.day02.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataTestDrive {

	public static void main(String[] args) {
		// ResultSetMetaData를 이용하여 emp 테이블에 있는 전체 데이터를 표출하세요

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/empdept?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url, "ssafy", "ssafy");

			String sql = "select * from emp";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();

			for (int i = 0; i < md.getColumnCount(); i++) {
				System.out.print(md.getColumnName(i + 1) + "\t");
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.println(rs.getInt("empno") + "\t"
						+ rs.getString("ename") + "\t" + rs.getString(3) + "\t"
						+ rs.getInt(4) + "\t" + rs.getDate(5) + "\t"
						+ rs.getInt(6) + "\t" + rs.getInt(7) + "\t"
						+ rs.getInt(8));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
