package thread;

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread mainTh = Thread.currentThread();
		System.out.println("���� ������ �̸� : " + mainTh.getName());
		
		ThreadA thA = new ThreadA();
		System.out.println("�۾� ������ �̸� : " + thA.getName());
		thA.start();
		
		ThreadB thB = new ThreadB();
		System.out.println("�۾� ������ �̸� : " + thB.getName());
		thB.start();
	}
}
