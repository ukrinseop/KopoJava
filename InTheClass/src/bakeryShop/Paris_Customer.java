package bakeryShop;

public class Paris_Customer implements Runnable {
//	public Paris_Customer(String thname) {
//		setName(thname + " Thread");
//	}
	
	@Override
	public void run() {
		while (true) {
			try {
				buy();
//				this.sleep(1000);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
	}

	public synchronized void buy() {
		Paris_Baguette.Baguette--;
		System.out.println(" buy " + Paris_Baguette.Baguette);
	}
}
