package dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconnSingleton2 {
	
	private static DBconnSingleton2 dst = new DBconnSingleton2();
	
	private DBconnSingleton2() {}
	
	public static DBconnSingleton2 getDBConn() {
		if(dst == null) {
			dst = new DBconnSingleton2();
		}
		return dst;
	}
	/*
	public class Singleton {

		   private static Singleton singleton = new Singleton( );

		    //A private Constructor prevents any other
		    //class from instantiating.
		    
		   private Singleton() { }

		   //static 'instance' method 
		   public static Singleton getInstance( ) {
		      return singleton;
		   }

		   //Other methods protected by singleton-ness 
		   protected static void demoMethod( ) {
		      System.out.println("demoMethod for singleton");
		   }
		} 
	*/
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "1234";
		conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}