package ch06_class;

public class Static_Car {
	int speed;
	
	void run() {
		System.out.println(speed + " km/h �� �޸��ϴ�");
	}
	
	public static void main(String[] args) {
		Static_Car car = new Static_Car();
		car.speed = 120;
		car.run();
		this.speed = 110; // �̰� �ν��Ͻ� �ʵ�� �ȵ�
		run(); // �ν��Ͻ��� �ȵ�	
	}
}
