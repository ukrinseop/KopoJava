package thread;

public class ThreadA extends Thread {
	public ThreadA() {
		setName("ThreadA");
		System.out.println("Thread�� �̸��� �����Ǿ����ϴ�");
		System.out.println("Thread �̸��� : " + getName());
	}
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "�� run()");
		}
	}
}
