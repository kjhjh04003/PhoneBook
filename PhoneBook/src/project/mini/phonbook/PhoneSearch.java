package project.mini.phonbook;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneSearch {
	public static void phoneSearch() {
		Scanner sc = new Scanner(System.in);
		System.out.println();

		System.out.println("<4. 검색>");
		System.out.print(">이름: ");
		String fname = sc.next();

		PhoneBookDAO dao = new PhoneBookDAOImpl();
		List<PhoneBookVO> list = dao.phoneSearch(fname);

		Iterator<PhoneBookVO> iter = list.iterator();

		while (iter.hasNext()) {
			PhoneBookVO vo = iter.next();
			System.out.printf("%d.\t%s\t%s\t%s%n", vo.getId(), vo.getUname(), vo.getUhp(), vo.getUtel());
		}
		System.out.println();
	}

}
