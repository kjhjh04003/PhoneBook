package project.mini.phonbook;

import java.util.List;

public interface PhoneBookDAO {

	// 설계도
	public List<PhoneBookVO> phoneList(); // 단순 SELECT, PhoneList 확인

	public boolean phoneInsert(PhoneBookVO vo); // INSERT, 등록

	public boolean phoneRemove(Long id); // PK로 삭제

	public List<PhoneBookVO> phoneSearch(String keyword); // LIKE로 검색

}
