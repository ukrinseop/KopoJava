package thread;

public class Consumer extends Thread {
	public void run() {
		while (true) {
			try {
				HamTest.sp.buy(); // sp == supplier를 뜻함
				this.sleep(2000); // 2초마다 4개가 동시에 -1하면 안됨 buy()는 동기화
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
