package com.kopo.human;

public class ThrowsMain {
	public void test() {
		ThrowsTest tt = new ThrowsTest();
//		tt.test(0); // 에러가 났음
		try {
			tt.test(0);
		} catch(Exception e) {
			System.out.println("예외가 발생했습니다");
//			throw new KopoException(e); throw의 사용법, 한 클래스로 모아서 한군데에서 처리함 
		} finally {
			System.out.println("Finally 실행");
		}
	}
	
	public static void main(String[] args) {
		ThrowsMain tm = new ThrowsMain();
		tm.test();
	}
	
}
