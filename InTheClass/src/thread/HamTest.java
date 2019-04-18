package thread;

public class HamTest {

	public static Supplier sp = new Supplier();
	// 공급자가 공유자원인 빵을 가지고 있으므로 static

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
