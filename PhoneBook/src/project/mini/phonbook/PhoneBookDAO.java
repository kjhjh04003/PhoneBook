package project.mini.phonbook;

import java.util.List;

public interface PhoneBookDAO {

	// 설계도 - 21.06.01 by.준형
	public List<PhoneBookVO> phoneList(); // PhoneList 확인 - 21.06.01 by.준형

	public boolean phoneInsert(PhoneBookVO vo); // 사용자 등록 - 21.06.01 by.준형

	public boolean phoneRemove(Long id); // 사용자 삭제 - 21.06.01 by.준형

	public List<PhoneBookVO> phoneSearch(String keyword); // 이름 검색 - 21.06.01 by.준형

}
