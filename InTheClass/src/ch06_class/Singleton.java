package ch06_class;

public class Singleton {

	   private static Singleton singleton = new Singleton( );

	   /* A private Constructor prevents any other
	    * class from instantiating.
	    */
	   private Singleton() { }

	   /* Static 'instance' method */
	   public static Singleton getInstance( ) {
	      return singleton;
	   }

	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for singleton");
	   }
	}









/*
	private static Singleton s = new Singleton();
	private Singleton() {
	}
	Static Singleton getInstance() {
		return singleton;
	}
}
*/