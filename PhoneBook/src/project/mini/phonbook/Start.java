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
				PhoneList.phonelist();
			} else if (n == 2) {
				PhoneInsert.phoneInsert();
			} else if (n == 3) {
				PhoneRemove.removePhone();
			} else if (n == 4) {
				PhoneSearch.phoneSearch();
			} else if (n == 5) {
				Exit.exit(); // 종료 클래스의 종료 함수 호출
			} else {
				System.out.println("[다시 입력해주세요]");
				System.out.println();
			}
		}

	}
}
