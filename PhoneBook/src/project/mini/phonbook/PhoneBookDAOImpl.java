package project.mini.phonbook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookDAOImpl implements PhoneBookDAO {

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
	public List<PhoneBookVO> phoneList() {
		Connection conn = null; // Connection 객체
		Statement stmt = null; // SQL 실행에 필요한 객체

		// Select
		ResultSet rs = null; // SQL 결과를 담을 객체

		// java의 결과 객체
		List<PhoneBookVO> list = new ArrayList<>();

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			// 쿼리
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
	public boolean phoneInsert(PhoneBookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0; // 반환 갯수

		try {
			conn = getConnection();

			// 실행 계획
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
	public boolean phoneRemove(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;

		try {
			conn = getConnection();
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
	public List<PhoneBookVO> phoneSearch(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<PhoneBookVO> list = new ArrayList<>();
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
