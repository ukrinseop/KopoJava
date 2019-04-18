package ch06_class;

public class SingletonExample {
	public static void main(String[] args) {
		/*
		 * Singleton ss1 = new Singleton();
		 * Singleton ss2 = new Singleton();
		 */
		
		Singleton ss1 = Singleton.getInstance();
		Singleton ss2 = Singleton.getInstance();
		
		if(ss1 == ss2) {
			System.out.println("ss1과 ss2는 같은 객체입니다");
		} else {
			System.out.println("ss1과 ss2는 다른 객체입니다");
		}
	}
}
