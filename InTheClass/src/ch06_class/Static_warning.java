package ch06_class;

public class Static_warning {
	//�ν��Ͻ� �ʵ�� �޼ҵ�
	int field1;
	void method1 () {
		
	}
	
	//���� �ʵ�� �޼ҵ�
	static int field2;
	static void method2() {
		
	}
	
	//���� ��
	static {
		field1 = 10; // static�� �ƴ� �ʵ�, ������ ����
		method1(); // static�� �ƴ� �޼ҵ�, ������ ����
		field2 = 10;
		method2();
	}
	
	//���� �޼ҵ�
	static void Method3() {
		this.field1;
		this.method1();
		field2 = 10;
		method2();
	}
}
