package com.kopo.human;

public class ThrowsTest {
	public void test(int number) throws Exception{
		int result = 4 / number;
		System.out.println("��� ��� : " + result);
	}
	public static void main(String[] args) throws Exception { // jvm�� ����. �׷��� �ϸ� �ȵ�
		ThrowsTest tt = new ThrowsTest();
		tt.test(0); 
	}
}
