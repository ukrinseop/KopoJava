package dbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BBSDaoImpl { // �������� ���ִ� bbs �������̽�
	// ���� �Ἥ Ȯ�� ������ �� Ŭ������ �ҷ��� �޼ҵ� ����
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

//	------������ʹ�  insert, select, update, delete-----------------------------
	
	
	public void insertBBS(BBSDto article) { // �ѹ��� �� ���� ���ڵ常 ���� �� ����
		try {
			query = new StringBuilder(); // StringBuilder query
			query.append("INSERT INTO BBS VALUES(");
			query.append("BBS_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, ?)");
			conn = DBconnSingleton2.getDBConn().getConnection();
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, article.getID()); // index �� ��° ����ǥ
			ps.setString(2, article.getTITLE());
			ps.setString(3, article.getCONTENT());
			ps.setString(4, article.getFNAME());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertBBSAll(ArrayList<BBSDto> articleList) { // �ѹ��� ���� ���ڵ带 ���� �� ����
		try {
			query = new StringBuilder(); // query�� StringBuilder�� ������
			query.append("INSERT INTO BBS VALUES(");
			query.append("BBS_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, ?)");
			conn = DBconnSingleton2.getDBConn().getConnection();
			ps = conn.prepareStatement(query.toString());
			for (BBSDto article : articleList) { // articleList�� ArrayList<BBDto>�� ������
				ps.setString(1, article.getID()); // index �� ��° ����ǥ
				ps.setString(2, article.getTITLE());
				ps.setString(3, article.getCONTENT());
				ps.setString(4, article.getFNAME());
				ps.executeUpdate();
				// SELECT�� ���, executeQuery()
				// SELECT�� ������ Query���� executeUpdate()
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectBBS(int ARTICLENUM) { //BBSDto ���� �ʵ�
		try {
			query = new StringBuilder();
			query.append("SELECT * ");
			query.append("FROM BBS ");
			query.append("WHERE ARTICLENUM=?");
			
			conn = DBconnSingleton2.getDBConn().getConnection();
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, ARTICLENUM); // index �� ��° ����ǥ
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
	
	public void updateBBS(int ARTICLENUM) { // ID�� �ٲܰ�
		try {
			query = new StringBuilder();
			query.append("UPDATE BBS ");
			query.append("SET ID =? ");
			query.append("WHERE ARTICLENUM=?");
			
			conn = DBconnSingleton2.getDBConn().getConnection();
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, "TODAY"); // index �� ��° ����ǥ
			ps.setInt(2, ARTICLENUM); // index �� ��° ����ǥ
			
			ps.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBBS(int ARTICLENUM) { // ID�� �ٲܰ�
		try {
			query = new StringBuilder();
			query.append("DELETE ");
			query.append("FROM BBS ");
			query.append("WHERE ARTICLENUM=?");
			
			conn = DBconnSingleton2.getDBConn().getConnection();
//			conn.setAutoCommit(false); // ����Ŀ���� ���Ͼ�� �� �� ����
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, ARTICLENUM); // index �� ��° ����ǥ
			
			ps.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
