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
		int string = 0;
		
		for (int i = 0; i <= s.length(); i++) {
			
		}
		
		
		if (s.length() > 0 && s.length() < 9) {
			string = Integer.parseInt(s);
			answer = true;
			
		} else {
			answer = false;
		}
		return answer;
	}
		
		      
	public static void main(String[] args) {
		BasicOfString bos = new BasicOfString();
		System.out.println(bos.solution("1a34"));
		
		String abc = "";
		abc.toCharArray();
		ddddddddddddddddddd;
		
		
	}
	
}
		      
		
		
		

	


