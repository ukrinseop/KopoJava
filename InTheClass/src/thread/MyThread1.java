package thread;

public class MyThread1 extends Thread {
	String name;

	MyThread1(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " : " + i);
		}
	}
}
