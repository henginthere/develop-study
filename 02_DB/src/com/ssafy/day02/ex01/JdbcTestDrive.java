package com.ssafy.day02.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTestDrive {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 완료.....");

			// 2. Connection
			String url = "jdbc:mysql://127.0.0.1:3306/empdept?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy"); //connection을 열었다는 것은 db와 컴퓨터가 연결되었다는 것
			System.out.println(conn.getClass().getName());
			System.out.println("Connection 완료.....");

			// 3. Query를 수행할 Statement 객체를 가져옴
			stmt = conn.createStatement();

			// 4. Execute
			String sQuery = "select empno, ename, job, sal from emp";
			result = stmt.executeQuery(sQuery);

			// 5. Result
			while (result.next()) {
				System.out.println(result.getInt(1) + "\t"
						+ result.getString(2) + "\t" + result.getString(3)
						+ "\t" + result.getString(4));
			}

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO EMP (EMPNO, ENAME, JOB) VALUES(?,?,?)");
			for (int i = 0; i < 1; i++) {
				ps.setInt(1, 1001);
				ps.setString(2, "홍길동");
				ps.setString(3, "MANAGER");
				ps.addBatch();
				ps.clearParameters();
			}
			ps.executeBatch();

			// 6. Release resource
			result.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
