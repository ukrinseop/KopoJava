package thread;

public class ThreadExam1 {
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("first");
		MyThread1 t2 = new MyThread1("second");

		t1.start();
		t2.start();
	}
}