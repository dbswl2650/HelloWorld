package com.yedam.methods;

/*
 *  학생의 성적관리 Prog.
 *  학생번호, 학생이름, 영어점수, 수학점수
 *  
 */

public class Student {
	private String studentNumber; // 필드.
	private String studentName;
	private int studentEscore;
	private int studentMscore;
	
	// 생성자. => 인스턴스를 생성하면서 필드의 값을 초기화해주는 기능.
	public Student(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public Student(String studentNumber, String studentName, int studentEscore, int studentMscore) {	
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentEscore = studentEscore;
		this.studentMscore = studentMscore;
	}
	
	// getter, setter. 메소드.
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentEscore() {
		return studentEscore;
	}

	public void setStudentEscore(int studentEscore) {
		this.studentEscore = studentEscore;
	}

	public int getStudentMscore() {
		return studentMscore;
	}

	public void setStudentMscore(int studentMscore) {
		this.studentMscore = studentMscore;
	}
	// showInfo()
	public String showInfo() {
		return "학번: " + studentNumber + ", 이름: " + studentName + ", 영어: " + studentEscore + ", 수학: " + studentMscore;
	}
	
}
