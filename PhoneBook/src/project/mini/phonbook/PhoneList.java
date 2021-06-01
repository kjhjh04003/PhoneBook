package project.mini.phonbook;

import java.util.Iterator;
import java.util.List;

// phone_book 테이블 전체 조회
public class PhoneList {
	public static void phonelist() {

		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		// 데이터값을 java의 list로 결과 출력하기 위한 객체 생성
		List<PhoneBookVO> list = dao.phoneList();

		// Iterator
		// 리스트에 저장된 요소를 확인하기 위한 객체 생성
		Iterator<PhoneBookVO> iter = list.iterator();

		System.out.println("<1. 리스트>");

		while (iter.hasNext()) { // 요소가 남아있다면 
			// 데이터 추출
			PhoneBookVO item = iter.next(); // iterator에서 요소 추출
			System.out.printf("%d.\t%s\t%s\t%s%n", item.getId(), item.getUname(), item.getUhp(), item.getUtel());
		}
		System.out.println();
	}

}
