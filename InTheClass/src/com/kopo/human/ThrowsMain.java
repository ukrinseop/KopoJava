package com.kopo.human;

public class ThrowsMain {
	public void test() {
		ThrowsTest tt = new ThrowsTest();
//		tt.test(0); // ������ ����
		try {
			tt.test(0);
		} catch(Exception e) {
			System.out.println("���ܰ� �߻��߽��ϴ�");
//			throw new KopoException(e); throw�� ����, �� Ŭ������ ��Ƽ� �ѱ������� ó���� 
		} finally {
			System.out.println("Finally ����");
		}
	}
	
	public static void main(String[] args) {
		ThrowsMain tm = new ThrowsMain();
		tm.test();
	}
	
}
