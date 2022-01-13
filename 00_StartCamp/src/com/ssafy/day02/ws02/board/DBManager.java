package com.ssafy.day02.ws02.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
	public static final String URL = "jdbc:mysql://localhost:3306";
	public static final String DB_NAME = "ssafy";
	public static final String DB_ARGS = "serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String ID = "ssafy";
	public static final String PASSWORD = "ssafy";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 싱글턴 패턴 (Singleton Pattern): Board 프로그램 내부에서 객체 하나만 생성하도록 하는 패턴
	private static DBManager instance;

	private DBManager() {	// private: 클래스 내부에서만 객체를 생성하도록 하기위해
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 실패");
		}
	}

	public static DBManager getInstance() {
		if (instance == null) {	// null일 경우는 아직 한번도 객체를 생성하지 않은 경우
			instance = new DBManager();	// 객체를 생성한다.
		}
		return instance;	// 방금 생성한 객체를 리턴하거나 기존에 생성했었던 객체를 리턴
	}
	//////////////////////////////////////////////////////

	public List<Board> selectAll() throws SQLException {
		conn = DriverManager.getConnection(URL + "/" + DB_NAME + "?" + DB_ARGS, ID, PASSWORD);
		String sql = "SELECT * FROM board";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		List<Board> list = new ArrayList<Board>();
		while (rs.next()) {
			Board item = new Board(rs.getInt("no"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("writer"),
					rs.getTimestamp("regdate"),
					rs.getTimestamp("modidate"));
			list.add(item);
		}
		this.close();

		return list;
	}

	public void insert(Board board) throws SQLException {
		// 1. 데이터베이스와 연결
		conn = DriverManager.getConnection(URL + "/" + DB_NAME + "?" + DB_ARGS, ID, PASSWORD);

		// 2. SQL문 작성
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO board (title, content, writer, regdate, modidate) ");
		sql.append("VALUES (?, ?, ?, NOW(), NULL)");

		// 3. SQL문 실행을 위한 객체 생성
		pstmt = conn.prepareStatement(sql.toString());

		// 4. SQL문의 물음표 채우기
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());

		// 5. 채운 SQL문 실행
		pstmt.executeUpdate();

		// 6. 객체 연결 해제하는 메소드 호출
		this.close();
	}

	public void delete(int id) throws SQLException {
		// 1. 데이터베이스와 연결
		conn = DriverManager.getConnection(URL + "/" + DB_NAME + "?" + DB_ARGS, ID, PASSWORD);

		// 2. SQL문 작성
		String sql = "DELETE FROM board WHERE no = ?";

		// 3. SQL문 실행을 위한 객체 생성
		pstmt = conn.prepareStatement(sql);

		// 4. SQL문의 물음표 채우기
		pstmt.setInt(1, id);

		// 5. 채운 SQL문 실행
		pstmt.executeUpdate();

		// 6. 객체 연결 해제하는 메소드 호출
		this.close();
	}

	public void update(Board board) throws SQLException {
		// 1. 데이터베이스와 연결
		conn = DriverManager.getConnection(URL + "/" + DB_NAME + "?" + DB_ARGS, ID, PASSWORD);

		// 2. SQL문 작성 
		StringBuilder sql = new StringBuilder(); 
		sql.append("UPDATE board ");
		sql.append("SET title = ?, content = ?, modidate = NOW() ");
		sql.append("WHERE no = ?");

		// 3. SQL문 실행을 위한 객체 생성
		pstmt = conn.prepareStatement(sql.toString());

		// 4. SQL문의 물음표 채우기
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getId());

		// 5. 채운 SQL문 실행
		pstmt.executeUpdate();

		// 6. 객체 연결 해제하는 메소드 호출
		this.close();
	}

	// 객체 연결 해제
	private void close() throws SQLException {
		if (rs != null) { rs.close(); }
		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
	}
}





