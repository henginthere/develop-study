package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

public class BoardDao {

	public List<Board> list() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Board> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from BOARD order by NO desc";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				
				board.setContent(rs.getString("CONTENT"));
				board.setNo(rs.getInt("NO"));
				board.setReqDate(rs.getTimestamp("REGDATE"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				
				list.add(board);
			}
		}
		finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return list;
	}



}
