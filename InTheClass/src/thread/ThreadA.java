package thread;

public class ThreadA extends Thread {
	public ThreadA() {
		setName("ThreadA");
		System.out.println("Thread의 이름이 생성되었습니다");
		System.out.println("Thread 이름은 : " + getName());
	}
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "의 run()");
		}
	}
}
