package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
		// 퀴리실행 위한 필드 선언.
	public Connection conn = null;
	public PreparedStatement psmt;
	public ResultSet rs;
		
		// 연결해제.
		public void disConnect() {
			try {
				if(conn != null)
					conn.close();
				if(psmt != null)
					psmt.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 연결.
		public Connection getConn() {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
				// Connection 객체 db, 사용자, 비번
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "proj", "proj");
			} catch (Exception e) {
				System.out.println("연결중 에러");
				e.printStackTrace(); // 로그 출력
			}
			return conn; // connection 객체 반환
		}
}
