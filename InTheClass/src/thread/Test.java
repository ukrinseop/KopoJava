package thread;
public class Test {
	static long total=0;

	public static void main(String[] args) throws Exception{
	   SumTest st = new SumTest(); 
	   st.test();
//	   
	   SumTest1 st1 = new SumTest1(3_000_000_000l);
	   SumTest1 st2 = new SumTest1(6_000_000_000L);
	   SumTest1 st3 = new SumTest1(9_000_000_000L);
//	   SumTest1 st4 = new SumTest1(8_000_000_000L);
//	   SumTest1 st5 = new SumTest1(10_000_000_000L);

//	   st4.start();
//	   st5.start();	   
	    
	}

}
