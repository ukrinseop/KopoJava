package thread;

public class HamTest {

	public static Supplier sp = new Supplier();
	// �����ڰ� �����ڿ��� ���� ������ �����Ƿ� static

	public static void main(String[] args) {

		sp.start();
		
		try {
			Consumer cs1 = new Consumer();
			Consumer cs2 = new Consumer();
			Consumer cs3 = new Consumer();
			Consumer cs4 = new Consumer();
			cs1.start();
			cs2.start();
			cs3.start();
			cs4.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
