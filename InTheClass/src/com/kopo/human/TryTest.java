package com.kopo.human;

public class TryTest {
	public static void main(String[] args) {
		TryTest tt = new TryTest();
		tt.test(0);
	}
	public void test(int number) {
		try {
			int result = 4/number;
			System.out.println("결과출력 : " + result);
		} catch(Exception e) {
			System.out.println("입력값이 0이 올 수 없습니다");
			e.printStackTrace();
//			e.toString();
//			e.getMessage();
		} finally {
			System.out.println("무조건 출력");
		}
	}
}
