package project.mini.phonbook;

import java.util.Scanner;

public class Start {

	public static void start() {
		System.out.println("******************************");
		System.out.println("*      전화번호 관리 프로그램      *");
		System.out.println("******************************");

		while (true) {
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("-----------------------------");
			System.out.print(">메뉴번호: ");
			System.out.println();

			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt(); // 번호 입력

			if (n == 1) {
				PhoneList.phonelist(); // phone_book 테이블 전체 조회 메서드 호출
			} else if (n == 2) {
				PhoneInsert.phoneInsert(); // phone_book 테이블 정보 삽입 메서드 호출
			} else if (n == 3) {
				PhoneRemove.removePhone(); // phone_book 테이블 정보 삭제 메서드 호출
			} else if (n == 4) {
				PhoneSearch.phoneSearch(); // phone_book 테이블 특정값 검색 메서드 호출
			} else if (n == 5) {
				Exit.exit(); // 프로그램 종료 메서드 호출
			} else {
				System.out.println("[다시 입력해주세요]");
				System.out.println();
			}
		}

	}
}
