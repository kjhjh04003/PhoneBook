package project.mini.phonbook;

import java.util.Scanner;

// phone_book 테이블에 정보 삽입
public class PhoneInsert {
	public static void phoneInsert() {
		System.out.println("<2. 등록>");
		Scanner sc = new Scanner(System.in);

		System.out.print(">이름: ");
		String name = sc.next();
		System.out.print(">휴대전화: ");
		String phone = sc.next();
		System.out.print(">집전화: ");
		String tel = sc.next();

		// 입력받은 데이터를 전달받을 vo 객체 생성
		PhoneBookVO vo = new PhoneBookVO(null, name, phone, tel);
		// 입력받은 데이터로 메서드를 이용하여 실제 값을 반환해줄 dao 객체 생성
		PhoneBookDAO dao = new PhoneBookDAOImpl();

		boolean success = dao.phoneInsert(vo);

		System.out.println();
		System.out.println("[등록되었습니다.]");
		System.out.println();
	}

}
