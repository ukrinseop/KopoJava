package com.kopo.human;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		StringTokenizerTest stt = new StringTokenizerTest();
		stt.test1();
		test2();
	}
	public void test1() { // static이 없으므로 class자체를 instance로 만들어서(new) 그 안의 test1을 실행
		String test1 = "aaa bbb ccc ddd eee fff ggg";
		StringTokenizer st1 = new StringTokenizer(test1);
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
	}
	
	public static void test2() { // static을 붙였으므로 메인에서 그냥 메소드명
		String test2 = "aaa&bbb&ccc&ddd&eee&fff&ggg";
		StringTokenizer st2 = new StringTokenizer(test2, "&");
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
	}
	
	
}
