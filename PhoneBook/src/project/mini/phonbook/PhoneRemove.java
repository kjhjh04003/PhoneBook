package project.mini.phonbook;

import java.util.Scanner;

public class PhoneRemove {
	public static void removePhone() {
		Scanner sc = new Scanner(System.in);

		PhoneList.phonelist();
		System.out.println();
		System.out.println("<3. 삭제>");
		System.out.print(">번호: ");
		int pk = sc.nextInt();

		PhoneBookDAO dao = new PhoneBookDAOImpl();
		boolean success = dao.phoneRemove(Long.valueOf(pk));

		System.out.println("[삭제되었습니다.]");
		System.out.println();
	}

}
