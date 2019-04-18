package ch06_class;

public class Final_PersonExample {
	public static void main(String[] args) {
		Final_Person p1 = new Final_Person("123456-1234567", "계백");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		p1.name = "을지문덕";
		p1.ssn = "233";
		
	}
}
