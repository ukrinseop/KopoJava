package thread;

public class ThreadExample1 implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i < 1000; i++) {
			System.out.println("호호");
		}
	}

	public static void main(String[] args) {

		Runnable runnable = new ThreadExample1();
		Thread thread = new Thread(runnable);
		thread.start();
		
//		ThreadExample1 th = new ThreadExample1();
//		new Thread(th).start(); // 또다른 방법

		for (int i = 1; i < 1000; i++) {
			System.out.println("야야");
		}
	}

}
