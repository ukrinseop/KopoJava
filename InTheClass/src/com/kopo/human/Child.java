package com.kopo.human;

public class Child extends Parent {
	int num = 20;

	void show(int num) {
		System.out.println("�������� : " + num);
		System.out.println("�������� : " + this.num);
		System.out.println("�θ� �������� : " + super.num);
	}
}