package com.kopo.human;

public class SportsCar extends Car {
	public SportsCar() {
		System.out.println("SportsCar ��ü ����");
	}

	void openSunloof() {
		System.out.println("����� ����");
	}

	@Override
	void move() {
		System.out.println("100km/h �̵�");
	}
}