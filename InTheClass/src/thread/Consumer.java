package thread;

public class Consumer extends Thread {
	public void run() {
		while (true) {
			try {
				HamTest.sp.buy(); // sp == supplier�� ����
				this.sleep(2000); // 2�ʸ��� 4���� ���ÿ� -1�ϸ� �ȵ� buy()�� ����ȭ
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
