package project.mini.phonbook;

import java.util.Iterator;
import java.util.List;

public class PhoneList {
	public static void phonelist() {

		PhoneBookDAO dao = new PhoneBookDAOImpl();
		List<PhoneBookVO> list = dao.phoneList();

		// Iterator
		Iterator<PhoneBookVO> iter = list.iterator();

		System.out.println("<1. 리스트>");

		while (iter.hasNext()) {
			// 데이터 추출
			PhoneBookVO item = iter.next(); // iterator에서 요소 추출
			System.out.printf("%d.\t%s\t%s\t%s%n", item.getId(), item.getUname(), item.getUhp(), item.getUtel());
		}
		System.out.println();
	}

}
