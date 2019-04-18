package com.kopo.human;

public class Truck extends Car {
	public Truck() {
		System.out.println("Truck °´Ã¼ »ý¼º");
	}

	void load() {
		System.out.println("Áü ½ÇÀ½");
	}

	@Override
	void move() {
		System.out.println("50km/h ÀÌµ¿");
	}
}