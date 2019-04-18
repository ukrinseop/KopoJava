package ch06_class;

public class SingletonEx1 {
	//정적 필드
	private static SingletonEx1 ste = new SingletonEx1();
	
	
	//생성자
	private SingletonEx1() {
		
	}
	
	//정적 메소드
	static SingletonEx1 getInstance() {
		return singleton;
	}
}
