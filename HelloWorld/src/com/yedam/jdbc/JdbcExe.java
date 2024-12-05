package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExe {
	public static void main(String[] args) {
//		insert("Yun", "Jiwon@naver.com", "2024-12-04", "IT_PROG");
		update("jiwon", "010-8229-2650", 9000);
		select();
		System.out.println("end of prog");
	}
	
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			// Connection 객체 db, 사용자, 비번
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			System.out.println("연결중 에러");
			e.printStackTrace(); // 로그 출력
		}
		return conn; // connection 객체 반환
	}
	
	// 삭제기능.
	public static void delete(String lastName) {
		Connection conn = getConn();
		String query = "delete employees where last_name = Yun";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨.");
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 수정기능.
	public static void update(String fname, String pno, int sal) {
		Connection conn = getConn();
		String query = "update employees" 
				+ "        set first_name = '" + fname + "' " 
				+ "            ,phone_number = '" + pno + "' "
				+ "            ,salary = " + sal + " "
				+ "     where last_name = 'Yun' ";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨.");
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 입력기능.
	public static void insert(String lastName, String email, String hdate, String job) {
		Connection conn = getConn();
		String query = "insert into employees(employee_id, last_name, email, hire_date, job_id) "
				+ "values(employees_seq.nextval, '" + lastName + "', '" + email + "', '" + hdate + "', '" + job + "')";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨.");
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 조회기능.
	public static void select() {
		Connection conn = getConn();
		try {
			// sql 작성 Statement
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees where employee_id > 200 order by employee_id desc"); // 조회
			while (rs.next()) {
				System.err.println(rs.getString("EMPLOYEE_ID")
						+ rs.getString("LAST_NAME") + ", " //
						+ rs.getString("FIRST_NAME") + ", "//
						+ rs.getString("EMAIL") + ", "//
						+ rs.getString("SALARY") + ", "
						+ rs.getString("PHONE_NUMBER"));
			}
			conn.close(); // 연결해제
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("데이터 끝");
	}
}
