package dbConnector;

public class DeleteBBS {

	public void deleteBBS(int ARTICLENUM) {
		
		BBSDaoImpl.getDBObject().deleteBBS(ARTICLENUM);

	}

	public static void main(String[] args) {
		DeleteBBS db = new DeleteBBS();
		db.deleteBBS(30); // 30번 지울것
	}
}
