package dbConnector;

public class UpdateBBS { // Ÿ��Ʋ ���� �ٲٱ�
	public void updateBBS(int ARTICLENUM) {

		BBSDaoImpl.getDBObject().updateBBS(ARTICLENUM);

	}

	public static void main(String[] args) {
		UpdateBBS ub = new UpdateBBS();
		ub.updateBBS(25); // 25�� �ٲܰ�
	}
}
