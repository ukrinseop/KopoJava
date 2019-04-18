package dbConnector;

import java.sql.DriverManager;     //class -> getConnection() returning Connection <type>
import java.sql.Connection;        //interface -> prepareStatement() returning prepare'd'Statement<type>  
import java.sql.PreparedStatement; //interface -> executeQuery() returning ResulSet<type>
import java.sql.ResultSet;
// interface -> next() returning boolean ->getString() returning String <and> getInt() returning Int

public class DBConnection {
	
	Connection conn;      // prepareStatement("Query");
	PreparedStatement ps; // executeQuery();
	ResultSet rs;         // next(); getString(column_name); getInt(column_name);

	public void connect() throws Exception {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "1234";
		conn = DriverManager.getConnection(url, user, password);
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT FIRST_NAME, SALARY, DEPARTMENT_ID ");
		query.append("FROM EMPLOYEES "); // ������ �������

//		System.out.println(query); // ����� query.toString()�̶� ����, return�� stringBuilder type?
//		System.out.println();
//		System.out.println(query.toString()); // syso(query)�� ����
		
//		boolean result = true;
//		System.out.println(result = query.equals(query.toString()));
		
//		System.out.println(query.getClass().getName()); -> StringBuilder
//		System.out.println(query.toString().getClass().getName()); -> String
		
		ps = conn.prepareStatement(query.toString());
		rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getString("FIRST_NAME") + " ");
			System.out.print(rs.getInt("SALARY") + " ");
			System.out.println(rs.getInt("DEPARTMENT_ID") + " ");
		}
		
		conn.close();
		ps.close();
		rs.close();
		
	}

	public static void main(String[] args) throws Exception {
		DBConnection dbc = new DBConnection();
		dbc.connect();
	}
}