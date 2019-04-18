package bakeryShop;

public class Paris_Baguette extends Thread {
	
	public static int Baguette = 100;
	
//	public Paris_Baguette() {
//		setName("¡¶ªßªÁThread");
//	}

	public void run() {
		while (true) {
			try {
				this.sleep(2000);
				Baker();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void Baker() {
		this.Baguette++;
		System.out.println(" make " + Baguette);
	}
}