package com.kopo.human;

public class Truck extends Car {
	public Truck() {
		System.out.println("Truck ��ü ����");
	}

	void load() {
		System.out.println("�� ����");
	}

	@Override
	void move() {
		System.out.println("50km/h �̵�");
	}
}