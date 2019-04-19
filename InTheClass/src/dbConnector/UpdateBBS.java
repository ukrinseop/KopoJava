package dbConnector;

public class UpdateBBS { // 타이틀 값만 바꾸기
	public void updateBBS(int ARTICLENUM) {

		BBSDaoImpl.getDBObject().updateBBS(ARTICLENUM);

	}

	public static void main(String[] args) {
		UpdateBBS ub = new UpdateBBS();
		ub.updateBBS(25); // 25번 바꿀것
	}
}
