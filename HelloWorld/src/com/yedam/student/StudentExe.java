package com.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student("S001"); // 실체생성(인스턴스 생성)
		s1.studentName = "홍길동";
		s1.studentEscore = 60;
		s1.studentMscore = 70;
		System.out.println(s1.studentNumber + ", " + s1.studentName 
				+ "의 합계점수는 " + s1.sumScore() 
				+ " 평균은 " + s1.average());
		
		Student s2 = new Student("S002", "김길동");
		s2.studentEscore = 70;
		s2.studentMscore = 75;
		System.out.println(s2.studentNumber + ", " + s2.studentName 
				+  "의 합계점수는 " + s2.sumScore() 
				+ " 평균은 " + s2.average());
		
		Student s3 = new Student("S003", "최길동", 80, 90);
		System.out.println(s3.studentNumber + ", " + s3.studentName + ", eng" + s3.studentEscore + ", math: " + s3.studentMscore);
		
		System.out.println(s1 == s2);
		
		
		int num = 100;
		
		
	}

}
