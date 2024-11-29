package com.yedam.reference;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		String name = new String("홍길동"); // "홍길동";
		int age = 20;
		
		Friend f1 = new Friend();
		f1.friendName = "홍길동";
		f1.friendPhone = "010-1111-1111";
		f1.friendBirth = "1999-04-05";
		
		Friend f2 = new Friend();
		f2.friendName = "김민수";
		f2.friendPhone = "010-2222-2222";
		f2.friendBirth = "1999-08-08";
		
		Friend f3 = new Friend();
		f3.friendName = "최두식";
		f3.friendPhone = "010-3333-3333";
		f3.friendBirth = "1999-03-30";
		
		Friend[] myFriends = { f1, f2, f3 };
		
//		System.out.println(myFriends[0].friendName);
//		System.out.println(myFriends[0].friendPhone);
//		System.out.println(myFriends[0].friendBirth);
		
		// 이름 => 이름, 연락처, 생년월일 출력.
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = "";
		
		while(run) {
			boolean isExists = false;
			System.out.println("검색할 이름 입력>>> ");
			searchName = scn.nextLine();
			if (searchName.equals("quit")) {
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
			for (int i = 0; i < myFriends.length; i++) {
				if (myFriends[i].friendName.equals(searchName)) {
					System.out.println(myFriends[i].friendName);
					System.out.println(myFriends[i].friendPhone);
					System.out.println(myFriends[i].friendBirth);
					isExists = true;
				}	
			}
			if(!isExists) {
				System.out.println("찾는 이름 없음");
			}
	}
  }
}
