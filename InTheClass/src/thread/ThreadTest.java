package thread;



public class ThreadTest implements Runnable {
	public static void main(String[] args) {
		
		ThreadTest tt = new ThreadTest();
		
		Runnable runnable = new ThreadTest();
//		Thread thread = new Thread(runnable);
//		Thread th = new Thread(runnable);
//		thread.start();
//		th.start();
		
		
		Thread aa = new Thread(new Runnable() {//ThreadTest aa ¶ó°í ÇÏ¸é ¾ÈµÊ
			// ÀÍ¸í °´Ã¼ »ç¿ë

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Â¯½Ã·ë!");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} 
		});
		
		aa.setName("Thread-Â¯½Ã·ë"); // aaÀÇ ½º·¹µå ÀÌ¸§
		
		
		new Thread(tt).start(); // ÀÌ·¸°Ôµµ µÊ Á»´õ °£ÆíÇÑµí
		new Thread(runnable).start(); // À§¿¡²¨¶û °ÅÀÇ °°Àºµ¥ ¹«½¼Â÷ÀÌÁö?
		aa.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("¾ß");
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
			System.out.println("È£");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
