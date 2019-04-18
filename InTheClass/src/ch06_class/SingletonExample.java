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
			System.out.println("ss1�� ss2�� ���� ��ü�Դϴ�");
		} else {
			System.out.println("ss1�� ss2�� �ٸ� ��ü�Դϴ�");
		}
	}
}
