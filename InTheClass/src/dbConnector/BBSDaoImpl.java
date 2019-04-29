package dbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BBSDaoImpl { // 쿼리문이 들어가있는 bbs 인터페이스
	// 글을 써서 확인 누르면 이 클래스를 불러서 메소드 실행
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private StringBuilder query;

	private static BBSDaoImpl bbs = new BBSDaoImpl();

	private BBSDaoImpl() {}

	public static BBSDaoImpl getDBObject() {
		if (bbs == null) {
			bbs = new BBSDaoImpl();
		}
		return bbs;
	}

//	------여기부터는  insert, select, update, delete-----------------------------
	
	
	public void insertBBS(BBSDto article) { // 한번에 한 개의 레코드만 넣을 수 있음
		try {
			query = new StringBuilder(); // StringBuilder query
			query.append("INSERT INTO BBS VALUES(");
			query.append("BBS_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, ?)");
			conn = DBconnSingleton2.getDBConn().getConnection();
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, article.getID()); // index 몇 번째 물음표
			ps.setString(2, article.getTITLE());
			ps.setString(3, article.getCONTENT());
			ps.setString(4, article.getFNAME());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertBBSAll(ArrayList<BBSDto> articleList) { // 한번에 여러 레코드를 넣을 수 있음
		try {
			query = new StringBuilder(); // query는 StringBuilder의 변수명
			query.append("INSERT INTO BBS VALUES(");
			query.append("BBS_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, ?)");
			conn = DBconnSingleton2.getDBConn().getConnection();
			ps = conn.prepareStatement(query.toString());
			for (BBSDto article : articleList) { // articleList는 ArrayList<BBDto>의 변수명
				ps.setString(1, article.getID()); // index 몇 번째 물음표
				ps.setString(2, article.getTITLE());
				ps.setString(3, article.getCONTENT());
				ps.setString(4, article.getFNAME());
				ps.executeUpdate();
				// SELECT일 경우, executeQuery()
				// SELECT를 제외한 Query문은 executeUpdate()
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectBBS(int ARTICLENUM) { //BBSDto 안의 필드
		try {
			query = new StringBuilder();
			query.append("SELECT * ");
			query.append("FROM BBS ");
			query.append("WHERE ARTICLENUM=?");
			
			conn = DBconnSingleton2.getDBConn().getConnection();
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, ARTICLENUM); // index 몇 번째 물음표
			rs = ps.executeQuery();
			
			if(rs.next()) { //true if the new current row is valid; false if there are no more rows
				System.out.println(rs.getInt("ARTICLENUM") + " "); //getInt() the column value; if the value is SQL NULL, the value returned is 0
				System.out.println(rs.getString("ID") + " ");
				System.out.println(rs.getString("TITLE") + " ");
				System.out.println(rs.getString("CONTENT") + " ");
				System.out.println(rs.getString("WRITEDATE") + " ");
				System.out.println(rs.getString("FNAME") + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBBS(int ARTICLENUM) { // ID만 바꿀것
		try {
			query = new StringBuilder();
			query.append("UPDATE BBS ");
			query.append("SET ID =? ");
			query.append("WHERE ARTICLENUM=?");
			
			conn = DBconnSingleton2.getDBConn().getConnection();
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, "TODAY"); // index 몇 번째 물음표
			ps.setInt(2, ARTICLENUM); // index 몇 번째 물음표
			
			ps.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBBS(int ARTICLENUM) { // ID만 바꿀것
		try {
			query = new StringBuilder();
			query.append("DELETE ");
			query.append("FROM BBS ");
			query.append("WHERE ARTICLENUM=?");
			
			conn = DBconnSingleton2.getDBConn().getConnection();
//			conn.setAutoCommit(false); // 오토커밋이 안일어나게 할 수 있음
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, ARTICLENUM); // index 몇 번째 물음표
			
			ps.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
