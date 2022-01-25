package com.ssafy.day02.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JdbcDqlTestDrive {

	public static void main(String[] args) {
		// 드라이버 로딩, Connection 생성, Statement 생성
		try {

			// VM arguments에 -Dip="127.0.0.1"과 같이 입력하고 실행해야 한다
			Properties prop = System.getProperties();

			String ip = prop.getProperty("ip");
			String port = prop.getProperty("port");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + ip + ":" + port + "/empdept?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";

			Connection conn = DriverManager.getConnection(url, id, password);
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();

			// insert
			StringBuilder sql = new StringBuilder();
			sql.append("insert into emp values ");
			sql.append("(1001, '홍길동', 'CLERK', null, now(), 2000, 300, 20)");

			stmt.execute(sql.toString());

			// select
			sql = new StringBuilder();
			sql.append("select empno, ename, job, mgr, hiredate, sal, comm, deptno ");
			sql.append("from emp ");
			sql.append("where deptno=20");

			if (stmt.execute(sql.toString()) == true) {
				ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getInt("empno") + "\t"
							+ rs.getString("ename") + "\t" + rs.getString(3) + "\t"
							+ rs.getInt(4) + "\t" + rs.getDate(5) + "\t"
							+ rs.getInt(6) + "\t" + rs.getInt(7) + "\t"
							+ rs.getInt(8));
				}
				rs.close();
			}
			else {
				int nChangeCount = stmt.getUpdateCount();
			}

			// delete
			Scanner scanner = new Scanner(System.in);
			System.out.print("삭제할 사원번호를 입력하세요 : ");
			String result = scanner.next();

			sql = new StringBuilder();
			sql.append("delete from emp ");
			sql.append("where empno=" + result);

			stmt.execute(sql.toString());

			// select
			sql = new StringBuilder();
			sql.append("select empno, ename, job, mgr, hiredate, sal, comm, deptno ");
			sql.append("from emp ");
			sql.append("where deptno=20");

			if (stmt.execute(sql.toString()) == true) {
				ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getInt("empno") + "\t"
							+ rs.getString("ename") + "\t" + rs.getString(3) + "\t"
							+ rs.getInt(4) + "\t" + rs.getDate(5) + "\t"
							+ rs.getInt(6) + "\t" + rs.getInt(7) + "\t"
							+ rs.getInt(8));
				}
				rs.close();
			}

			scanner.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
