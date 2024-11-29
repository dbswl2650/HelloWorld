package com.yedam.reference;

import java.util.Scanner;

/*
 * 배열활용 연습.
 * 작성일지: 2024.11.29
 * 작성자: 윤지원
 * 
 * 수정일       수정자        수정내용
 * ---------------------------------
 * 2024.11.29  윤지원        신규작업
 * 
 */

public class ArrayEx3 {
	public static void main(String[] args) {
		// 배열의 인덱스 활용(같은 순번에 있는 값들은 동일한 사람의 값)
		String[] names = {"홍길동", "김민수", "최두식" };
		int[] scores = {80, 90, 70 };
//		for(int i = 0; i < names.length; i++)
//			System.out.println(names[i] + "의 점수는" + scores[i]);

			
		// quit 입력하면 프로그램 종료.
		boolean run = true;
		boolean isExists = false;
		Scanner scn = new Scanner(System.in);
		String searchName = ""; // 사용자 입력값. names[i].equals(searchName)
		
		while(run) {
			// names 배열에서 사용자 입력한 이름.
			System.out.println("이름");
			searchName = scn.nextLine();
			if (searchName.equals("quit")) {
				System.out.println("종료");
				run = false;
			}
			for(int i = 0; i < names.length; i++) {
				if (searchName.equals(names[i])) {
					System.out.println(names[i] + "의 점수는 " + scores[i] + "이다.");
					isExists = true;
				}
			}
			if(!isExists) {
				System.out.println("그런 이름 없음");
			}
		}
		System.out.println("프로그램 종료");
	}
}
