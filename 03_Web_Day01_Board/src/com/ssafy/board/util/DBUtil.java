package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

public class DBUtil {

	public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
		Connection conn = null;

		// DB 연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/ssafyboard?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
		conn = DriverManager.getConnection(url, "ssafy", "ssafy");

		return conn;
	}

	public static void close(AutoCloseable autoCloseable) {
		if (autoCloseable == null) {
			return;
		}

		try {
			autoCloseable.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
