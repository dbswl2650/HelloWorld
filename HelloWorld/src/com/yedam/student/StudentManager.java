package com.yedam.student;

import java.util.Scanner;

/*
 *  CRUD 처리.
 *  1.추가 2.목록 3.수정(영어, 수학) 4.삭제 9.종료
 */
public class StudentManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Student[] storage = new Student[10];

		while (run) {
			System.out.println("1.추가 2.목록 3.수정 4.삭제 5.상세조회(합계,평균) 6.합계점수기준 정렬 9.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				System.out.print("학생 번호 입력>> ");
				String number = scn.nextLine();
				System.out.print("학생 이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("영어 점수 입력>> ");
				int escore = Integer.parseInt(scn.nextLine());
				System.out.print("수학 점수 입력>> ");
				int mscore = Integer.parseInt(scn.nextLine());

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] == null) {
						storage[i] = new Student(number, name, escore, mscore); // 인스턴스 생성.
						break;
					}
				}
				break;
			case 2:
				System.out.println("----------------목록----------------");
				System.out.println("학생번호  이름    수학점수   영어점수");
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
//						System.out.printf("번호: %2s번 이름: %2s 영어점수: %2s점 수학점수: %2s점 \n", storage[i].studentNumber,
//								storage[i].studentName, storage[i].studentEscore, storage[i].studentMscore);
						storage[i].introduce();
					}
				}
				break;
			case 3:
				System.out.print("학생 이름 입력>> ");
				name = scn.nextLine();
				System.out.print("수정할 영어 점수 입력>> ");
				escore = Integer.parseInt(scn.nextLine());
				System.out.print("수정할 수학 점수 입력>> ");
				mscore = Integer.parseInt(scn.nextLine());
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].studentName.equals(name)) {
							storage[i].studentEscore = escore;
							storage[i].studentMscore = mscore;
							break;
						}
					}
				}
				break;
			case 4:
				System.out.print("삭제할 학생 이름 입력>> ");
				name = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].studentName.equals(name)) {
							storage[i] = null;
							System.out.println("삭제 되었습니다");
							break;
						}
					}
				}
				break;
			case 5:
				System.out.print("상세 조회 할 학생 이름 입력>> ");
				name = scn.nextLine();
				double sum = 0, avg = 0;
				for (int i = 0; i < storage.length; i++) {
					sum += storage[i].studentEscore + storage[i].studentMscore;
					avg = sum / 2;
					System.out.println("합계: " + sum + "평균: " + avg);
					break;
				}
				break;
			case 6:
				for (int j = 0; j < storage.length; j++) {
					for (int i = 0; i < storage.length; i++) {
						if (storage[0].studentEscore + storage[0].studentMscore > storage[1].studentEscore
								+ storage[1].studentMscore) {
							Student temp = storage[0];
							storage[0] = storage[1];
							storage[1] = temp;
						}
					}
				}
			case 9:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");
				System.out.println("프로그램 끝");
			}
		}
	}
}
