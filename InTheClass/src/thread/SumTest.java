package thread;
public class SumTest {
	long total;
	long i;
	public void test(){
		long before = System.currentTimeMillis();
		for( i=0; i<=9_000_000_000L;i++){
			total= total+i;
		}
		System.out.println(System.currentTimeMillis()-before);
		System.out.println(total);	
		
	} 

}
