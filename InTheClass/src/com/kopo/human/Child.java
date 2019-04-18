package com.kopo.human;

public class Child extends Parent {
	int num = 20;

	void show(int num) {
		System.out.println("지역변수 : " + num);
		System.out.println("전역변수 : " + this.num);
		System.out.println("부모 전역변수 : " + super.num);
	}
}