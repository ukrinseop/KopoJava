package ch06_class;

public class SingletonEx1 {
	//���� �ʵ�
	private static SingletonEx1 ste = new SingletonEx1();
	
	
	//������
	private SingletonEx1() {
		
	}
	
	//���� �޼ҵ�
	static SingletonEx1 getInstance() {
		return singleton;
	}
}
