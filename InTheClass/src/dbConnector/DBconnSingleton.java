package dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconnSingleton {
	private static DBconnSingleton dst = new DBconnSingleton();
	
	private DBconnSingleton() {
		
	}
	
	public static DBconnSingleton getDBConn() {
		if(dst == null) {
			dst = new DBconnSingleton();
		}
		return dst;
	}
	
}
