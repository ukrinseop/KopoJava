package thread;



public class ThreadTest implements Runnable {
	public static void main(String[] args) {
		
		ThreadTest tt = new ThreadTest();
		
		Runnable runnable = new ThreadTest();
//		Thread thread = new Thread(runnable);
//		Thread th = new Thread(runnable);
//		thread.start();
//		th.start();
		
		
		Thread aa = new Thread(new Runnable() {//ThreadTest aa ��� �ϸ� �ȵ�
			// �͸� ��ü ���

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("¯�÷�!");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} 
		});
		
		aa.setName("Thread-¯�÷�"); // aa�� ������ �̸�
		
		
		new Thread(tt).start(); // �̷��Ե� �� ���� �����ѵ�
		new Thread(runnable).start(); // �������� ���� ������ ����������?
		aa.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("ȣ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
