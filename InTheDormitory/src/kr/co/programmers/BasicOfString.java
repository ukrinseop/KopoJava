package kr.co.programmers;

//���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�,
//���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�, solution�� �ϼ��ϼ���.
//���� ��� s�� a234�̸� False�� �����ϰ� 1234��� True�� �����ϸ� �˴ϴ�.
//
//���� ����
//s�� ���� 1 �̻�, ���� 8 ������ ���ڿ��Դϴ�.

public class BasicOfString {
// �ϴ� ���ڿ��� ���� �˾ƾ���
// �׸��� �������� ���������� �˾ƾ���, ��� ���ڿ��� True
	public boolean solution(String s) {
		boolean answer = true;
		char[] charr = {};
		String string = s;
		charr = string.toCharArray();
		
		for (int i = 0; i < string.length(); i++) {
		
			int a = charr[i];  //0 ~ 9 = 48 ~ 57
			
			if (a < 47 && a > 58) {
				answer = false;
			}
			if (a > 47 && a < 58) {
				answer = true;
			}
		}
		
		return answer;	
	}

	public static void main(String[] args) {
		BasicOfString bos = new BasicOfString();
		System.out.println(bos.solution("abcd"));
	}
}
