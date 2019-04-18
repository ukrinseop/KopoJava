package ch06_class;

public class Static_warning {
	//인스턴스 필드와 메소드
	int field1;
	void method1 () {
		
	}
	
	//정적 필드와 메소드
	static int field2;
	static void method2() {
		
	}
	
	//정적 블럭
	static {
		field1 = 10; // static이 아닌 필드, 컴파일 에러
		method1(); // static이 아닌 메소드, 컴파일 에러
		field2 = 10;
		method2();
	}
	
	//정적 메소드
	static void Method3() {
		this.field1;
		this.method1();
		field2 = 10;
		method2();
	}
}
