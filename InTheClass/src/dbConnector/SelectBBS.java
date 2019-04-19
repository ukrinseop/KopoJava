package dbConnector;

import java.sql.ResultSet;


public class SelectBBS {
	ResultSet rs;
	
	public void selectBBS(int ARTICLENUM) {
		
		BBSDaoImpl.getDBObject().selectBBS(ARTICLENUM);
		
	}


	public static void main(String[] args) {
		SelectBBS sb = new SelectBBS();
		sb.selectBBS(24);
	}
}
