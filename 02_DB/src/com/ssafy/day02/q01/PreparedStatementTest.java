package com.ssafy.day02.q01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementTest {

	public static void main(String[] args) throws Exception {
		
	// 1. 드라이버 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 로딩 완료.....");

	// 2. Connetion 객체 만들기
		String url = "jdbc:mysql://127.0.0.1:3306/empdept?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
		Connection conn = DriverManager.getConnection(url, "ssafy", "ssafy");
		System.out.println("Connection 완료.....");
		
	// 3. Query를 수행할 Statement 객체 가져오기
		PreparedStatement pstmt = conn.prepareStatement("select * from emp where ename?"); //직원 이름을 기준으로 직원 정보를 가져올 것
		pstmt.setString(1, "Smith"); //첫번째 물음표에 smith 값을 입력하고 싶다
		
	// 4. Execute
		ResultSet rs = pstmt.executeQuery();
		
	// 5. ResultSet 내용을 출력
		while(rs.next()) {
		System.out.println(rs.getInt("empno")+" "+rs.getString("ename")); //컬럼명 작성하면 해당 컬럼에 대한 내용 출력가능 (empno, ename)
		}
		
	//insert 하는 방법
		
	// 3. Query를 수행할 Statement 객체 가져오기
			pstmt = conn.prepareStatement("insert into emp (empno, ename, job) values(?,?,?)"); //직원 이름을 기준으로 직원 정보를 가져올 것
			pstmt.setInt(1, 1001);
			pstmt.setString(2,"홍길동");
			pstmt.setString(3, "manager");
			
		// 4. Execute
			int result = pstmt.executeUpdate(); //dml(select문을 제외한 dml은 executeUpdate 실행)
			
		// 5. 결과 int 값 출력
			System.out.println(result); //추가된 정보 개수 return
				
		
	}
	
	
}
