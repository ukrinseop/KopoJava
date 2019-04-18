package com.kopo.human;

public class SportsCar extends Car {
	public SportsCar() {
		System.out.println("SportsCar 객체 생성");
	}

	void openSunloof() {
		System.out.println("썬루프 열림");
	}

	@Override
	void move() {
		System.out.println("100km/h 이동");
	}
}