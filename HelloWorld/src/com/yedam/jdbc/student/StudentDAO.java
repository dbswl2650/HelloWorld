package com.yedam.jdbc.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * DAO: Data Access Object.
 * 입력, 수정, 삭제, 죄회(목록, 단건) 
 */
public class StudentDAO extends DAO {
	
	// 상세조회
	// 반환: Student클래스, 매개:학생번호, 메소드: selectStudent
	public Student selectStudent(String sno) {
		getConn();
		String sql = "select * from tbl_student where std_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno); // 파라미터(?) 값 지정.
			rs = psmt.executeQuery();
			while(rs.next()) {
				Student std = new Student(); // 인스턴스 생성.
				std.setStdNo(rs.getString("std_no"));
				std.setStdName(rs.getString("std_name"));
				std.setStdPhone(rs.getString("std_phone"));
				std.setEngScore(rs.getInt("eng_score"));
				std.setEngScore(rs.getInt("math_score"));
				return std;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 점수 등록
	public boolean updateStudent(Student std) {
		getConn();
		String sql ="update tbl_student set eng_score = ? ,math_score =? where std_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, std.getEngScore());
			psmt.setInt(2, std.getMathScore());
			psmt.setString(3, std.getStdNo());
			
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true; // 정상 등록.
			}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
		return false;
	}
	// 등록. 반환:boolean, 매개:Student, 메소드:insertStudent.
	public boolean insertStudent(Student std) {
		getConn();
		String sql = "insert into tbl_student (std_no" //
				+ "                           ,std_name" //
				+ "                           ,std_phone)" //
				+ "  values(?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo()); // std_no
			psmt.setString(2, std.getStdName()); // std_name
			psmt.setString(3, std.getStdPhone()); // std_phone
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true; // 정상 등록.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}

	// 학생목록.
	public ArrayList<Student> studentList() {
		getConn();
		// 조회결과를 반환.
		ArrayList<Student> studList = new ArrayList<Student>();

		String sql = "select * from tbl_student";
		try {
			psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환.
			rs = psmt.executeQuery();
			// 반복 ArrayList에 담는 작업.
			while (rs.next()) {
				Student stud = new Student();
				stud.setStdNo(rs.getString("std_no"));
				stud.setStdName(rs.getString("std_name"));
				stud.setStdPhone(rs.getString("std_phone"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setMathScore(rs.getInt("math_score"));

				studList.add(stud); // ArrayList에 추가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 트라이 캐치 둘중 하나가 끝나면 실행.
			disConnect(); // 연결해제.
		}
		// 반환값.
		return studList;
	}

}
