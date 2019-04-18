package com.kopo.human;

public class StringTest {
	public static void main(String[] args) {
		long first = System.currentTimeMillis();
		long result = 0;
		for (long i = 0; i < 10_000_000_000l; i++) {
			result = result + 1;
		}

//		==는 객체의 참조값 비교, Object 클래스의 equals()도 참조값비교
//		String 클래의 equals()는 오버라이딩 되어있음->문자열 내용비교				
		String aa = "aa";
		String bb = "aa";
		String cc = new String("aa");
		String dd = bb;
		System.out.println(aa.equals(bb)); // true
		System.out.println(aa.equals(cc)); // true
		System.out.println(aa == bb); // true
		System.out.println(bb == cc); // false
		System.out.println(aa == cc); // false
		System.out.println(dd == bb); // true
		System.out.println(dd.equals(cc)); // true
		System.out.println(System.currentTimeMillis() - first);
	}

}
