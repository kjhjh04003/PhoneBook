package project.mini.phonbook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 PhoneBookDAO 설계도를 기반으로 실체를 작성 - 21.06.01 by.준형
 */
public class PhoneBookDAOImpl implements PhoneBookDAO {

	// DB접속
	// 공통 메서드로 따로 분리해서 작성 - 21.06.01 by.준형
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, "c##bituser", "bituser");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}

		return conn;

	}

	@Override
	// phone_book 테이블 전체 조회
	public List<PhoneBookVO> phoneList() {
		Connection conn = null; // Connection 객체
		Statement stmt = null; // SQL 실행에 필요한 객체

		ResultSet rs = null; // SQL 결과를 담을 객체

		// java의 결과 객체
		List<PhoneBookVO> list = new ArrayList<>();

		try {
			conn = getConnection(); // db connection 객체를 메서드를 통해 얻어온다 - 21.06.01 by.준형
			stmt = conn.createStatement(); // sql 실행을 위한 문맥 객체 생성 - 21.06.01 by.준형

			// phone_book 테이블 조회 쿼리
			String sql = "SELECT id, name, hp, tel FROM phone_book";

			// 쿼리 실행
			rs = stmt.executeQuery(sql);

			// 실제 ResultSet을 java 객체로 변환
			while (rs.next()) { // 다음 레코드가 있으면 반환
				Long id = rs.getLong(1);
				String uname = rs.getString(2);
				String uhp = rs.getString(3);
				String utel = rs.getString(4);

				// DTO 객체
				PhoneBookVO vo = new PhoneBookVO(id, uname, uhp, utel);

				// DTO 객체를 list에 추가
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return list;
	}

	@Override
	// phone_book 테이블에 정보 삽입
	public boolean phoneInsert(PhoneBookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 바인딩을 위한 필드
		int insertedCount = 0; // 반환 갯수

		try {
			conn = getConnection();

			// id, 이름, 핸드폰번호, 전화번호 삽입 sql
			// ?를 이용하여 동적으로 바인딩 할 변후 설정
			String sql = "INSERT INTO phone_book VALUES(seq_phone_book_pk.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 파라미트 바인딩
			pstmt.setString(1, vo.getUname());
			pstmt.setString(2, vo.getUhp());
			pstmt.setString(3, vo.getUtel());

			// 쿼리 수행
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return 1 == insertedCount; // 삽입된 레코드가 1개이면 성공
	}

	@Override
	// id(PK)값을 이용한 정보 삭제
	public boolean phoneRemove(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;

		try {
			conn = getConnection();
			// id를 기준으로 삭제가 되기 때문에 동적으로 바인딩 할 id값을 ?로 설정
			String sql = "DELETE FROM phone_book WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);

			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return 1 == deletedCount;
	}

	@Override
	// 이름 검색
	public List<PhoneBookVO> phoneSearch(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// like를 이용한 검색으로 여러개의 반환이 있기 때문에 list로 결과를 전달받는다.
		List<PhoneBookVO> list = new ArrayList<>();

		// 특정 단어로 이름을 검색하여 찾기 때문에 where절 하위에 있는 like문이 동적으로 바인동 될 대상이다.
		String sql = "SELECT id, name, hp, tel FROM phone_book WHERE name LIKE ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");

			// 쿼리 수행
			rs = pstmt.executeQuery();

			// 변환 작업
			while (rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String ph = rs.getString(3);
				String tel = rs.getString(4);

				PhoneBookVO vo = new PhoneBookVO(id, name, ph, tel);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
			return list;
		}
	}
}
