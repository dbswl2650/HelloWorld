package com.yedam.reference;

import java.util.Scanner;

/*
 * 친구정보 저장 기능.
 * 1.추가 2.목록 3.조회(숙제) 9.종료
 * 		storage[1] = new Friend(); // 요렇게 꼭 사용하세요 !!!!!!! 중요.....
		storage[1].friendName = "홍길동";
		storage[1].friendPhone = "010-1111-1111";
		storage[1].friendBirth = "1999-01-01";
		

 */
public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Friend[] storage = new Friend[10]; // 친구정보 저장할수 있는 공간 10개 확보.
		while (run) {
			System.out.println("1.추가 2.목록 3.조회 4.수정 5.삭제 9.종료");
			System.out.print("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 추가.
				System.out.print("친구 이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("친구 연락처 입력>> ");
				String phone = scn.nextLine();
				System.out.print("친구 생일 입력>> ");
				String birth = scn.nextLine();
				
				for(int i = 0; i < storage.length; i++) {
//					System.out.println(storage[i]);
					if (storage[i] == null) { // 비어있는 위치에 저장.
						storage[i] = new Friend();
						storage[i].friendName = name;
						storage[i].friendPhone = phone;
						storage[i].friendBirth = birth;
						break;
					}
				}
				break;
			case 2: // 목록.
				for (int i = 0; i < storage.length; i++) {
					if(storage[i] != null) {
						System.out.printf("%2s %14s %9s \n" ,storage[i].friendName, storage[i].friendPhone, storage[i].friendBirth);
					}
				}
				break;
			case 3: // 조회.
				System.out.print("조회할 이름 입력>> ");
				String names = scn.nextLine();
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null && names.equals(storage[i].friendName)) {
						System.out.printf("%2s %14s %9s \n" ,storage[i].friendName, storage[i].friendPhone, storage[i].friendBirth);
					} else {
						System.out.println("조회할수 없습니다.");
					}
					break;
				}
				break;
			case 4:
				System.out.print("친구 이름 입력>> ");
				names = scn.nextLine();
				System.out.print("친구 연락처 입력>> ");
				phone = scn.nextLine();
				// 10개 중에서 6개 저장, 4개 null.
				for(int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 값이 아닌 요소 대상.
						if(storage[i].friendName.equals(names)) {
							storage[i].friendPhone = phone;
							break;
						}
					}
				}
				break;
			case 5:
				System.out.print("삭제할 이름 입력>> ");
				names = scn.nextLine();
				System.out.print("삭제할 연락처 입력>> ");
				phone = scn.nextLine();
				for(int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if(storage[i].friendName.equals(names)) {
							storage[i] = null;
							System.out.print("삭제 되었습니다>> ");
							break;
						}
					}
				}
				break;
			case 9: // 종료.
				run = false;
				break; // switch 종료.
			default: System.out.println("메뉴를 다시 선택하세요");
			System.out.println("프로그램 끝");
			}
		}
		
	}
}
