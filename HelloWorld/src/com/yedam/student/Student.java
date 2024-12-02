package com.yedam.student;

/*
 *  학생의 성적관리 Prog.
 *  학생번호, 학생이름, 영어점수, 수학점수
 *  
 */

public class Student {
	public String studentNumber; // 필드.
	public String studentName;
	public int studentEscore;
	public int studentMscore;
	
	// 컴파일러가 기본 생성자를 만들어준다.
//	public Student() {	}
	
	public Student(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public Student(String studentNumber, String studentName) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
	}
	
	public Student(String studentNumber, String studentName, int studentEscore, int studentMscore) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentEscore = studentEscore;
		this.studentMscore = studentMscore;
	}
	
	// 메소드.
	public void smile() {
		System.out.println("학생이 웃습니다.");
	}
	public void introduce() {
		System.out.println("이름은 " + studentName + " 이고 학번은 " + studentNumber);
	}
	
	public int sumScore() {
		return studentEscore + studentMscore;
	}
	
	public double average() {
		return (studentEscore + studentMscore)/ 2.0;
	}
}
	
