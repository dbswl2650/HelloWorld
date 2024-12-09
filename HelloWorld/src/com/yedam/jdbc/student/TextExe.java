package com.yedam.jdbc.student;

import java.util.ArrayList;

public class TextExe {
	public static void main(String[] args) {
		// 검색조건.
		Search search = new Search();
		search.setName("");
		search.setPhone("");
		search.setEngScore(0);
		search.setMathScore(0);
		search.setOrderBy("std_no");
		
		StudentDAO sdao = new StudentDAO();
		ArrayList<Student> list = sdao.studentList(search);		
		for (Student std : list) {
			System.out.println(std.showInfo());
		}
	}
}
