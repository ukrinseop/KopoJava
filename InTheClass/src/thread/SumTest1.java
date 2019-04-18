package thread;
public class SumTest1 extends Thread {	
	long amount;
	
	
	public SumTest1(long amount){
		this.amount= amount;
	}
	@Override
	public void run() {
		long before = System.currentTimeMillis();
		for(long i=amount-3_000_000_000L; i<=amount;i++){
			Test.total= Test.total+i;
		}
		System.out.println(System.currentTimeMillis()-before);
//	    최종결과값에는 버그가 있음..동기화를 안했으므로
		System.out.println(Test.total);		
	}
	

}
