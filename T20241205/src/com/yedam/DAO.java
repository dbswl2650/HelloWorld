package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAO {
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;
	
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
	
	public Connection getConnect() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			System.out.println("연결중 에러");
			e.printStackTrace();
		}
		return conn;
	}
}
