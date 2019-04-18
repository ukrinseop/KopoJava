package bakeryShop;

public class BakeryMain {
	
	public static Paris_Baguette pb = new Paris_Baguette();
	
	public static void main(String[] args) {

		new Paris_Baguette().start();
		Paris_Customer pc1 = new Paris_Customer();
		Paris_Customer pc2 = new Paris_Customer();
//		Paris_Customer pc3 = new Paris_Customer();
		
		new Thread(pc1).start();
		new Thread(pc2).start();
//		new Thread(pc3).start();

	}
}




//Thread customerThread2= new Thread(pc);
//Thread customerThread3 = new Thread(pc);
//Thread customerThread4 = new Thread(pc);
//Thread customerThread5 = new Thread(pc);
