package com.kopo.human;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		StringTokenizerTest stt = new StringTokenizerTest();
		stt.test1();
		test2();
	}
	public void test1() { // static�� �����Ƿ� class��ü�� instance�� ����(new) �� ���� test1�� ����
		String test1 = "aaa bbb ccc ddd eee fff ggg";
		StringTokenizer st1 = new StringTokenizer(test1);
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
	}
	
	public static void test2() { // static�� �ٿ����Ƿ� ���ο��� �׳� �޼ҵ��
		String test2 = "aaa&bbb&ccc&ddd&eee&fff&ggg";
		StringTokenizer st2 = new StringTokenizer(test2, "&");
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
	}
	
	
}
