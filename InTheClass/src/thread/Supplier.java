package thread;

public class Supplier extends Thread {
	public int Ham = 10;
	static int i = 1;
	int j = 1;

	public void run() { // Thread가 실행되면 3초있다가 make() 실행
		while (true) {
			try {
				Thread.sleep(3000);
				make();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void make() {
		Ham = Ham + 1;
		System.out.println(j + " 번째 햄버거 공급");
		this.notify(); // 빵이 0개이면 buy()를 못하므로, consumer를 wait를 시켜 다시 깨워야함
		// 먼저 들어온 애가 안들어올경우 notifyall();
		j++;
	}

	public synchronized void buy() {
		Thread t = Thread.currentThread();
		//먼저들어온 thread가 몇번인지 알아보기 위한
		while (Ham == 0) {
			System.out.println("햄버거 다팔림");
			System.out.println("wait된 쓰레드" + t.getName());
			try {
				wait();
				System.out.println("wait에서 깨어난 쓰레드 " + t.getName()); //우선순위 높은애
				System.out.println("쓰레드 상태 " + t.getState());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Ham = Ham - 1;
		System.out.println(t.getName() + " " + i + " 번째햄버거 팔림, " + " 남은햄버거" + Ham);
		i++;
	}
}
