package ch06_class;

public class Static_Car {
	int speed;
	
	void run() {
		System.out.println(speed + " km/h 로 달립니다");
	}
	
	public static void main(String[] args) {
		Static_Car car = new Static_Car();
		car.speed = 120;
		car.run();
		this.speed = 110; // 이건 인스턴스 필드라서 안됨
		run(); // 인스턴스라 안됨	
	}
}
