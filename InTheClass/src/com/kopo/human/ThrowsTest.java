package com.kopo.human;

public class ThrowsTest {
	public void test(int number) throws Exception{
		int result = 4 / number;
		System.out.println("결과 출력 : " + result);
	}
	public static void main(String[] args) throws Exception { // jvm에 던짐. 그런데 하면 안됨
		ThrowsTest tt = new ThrowsTest();
		tt.test(0); 
	}
}
