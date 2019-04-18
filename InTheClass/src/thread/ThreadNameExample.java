package thread;

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread mainTh = Thread.currentThread();
		System.out.println("메인 스레드 이름 : " + mainTh.getName());
		
		ThreadA thA = new ThreadA();
		System.out.println("작업 스레드 이름 : " + thA.getName());
		thA.start();
		
		ThreadB thB = new ThreadB();
		System.out.println("작업 스레드 이름 : " + thB.getName());
		thB.start();
	}
}
