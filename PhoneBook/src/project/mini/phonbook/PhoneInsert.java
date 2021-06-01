package project.mini.phonbook;

import java.util.Scanner;

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

		PhoneBookVO vo = new PhoneBookVO(null, name, phone, tel);
		PhoneBookDAO dao = new PhoneBookDAOImpl();

		boolean success = dao.phoneInsert(vo);

		System.out.println();
		System.out.println("[등록되었습니다.]");
		System.out.println();
	}

}
