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
//		char[] charr = {};
		String string = s;
		
		if (s.length() > 0 && s.length() < 9) {
			char[]charr = string.toCharArray();
			for (int i = 0; i < string.length(); i++) {
				int a = charr[i]; // 0 ~ 9 = 48 ~ 57
				if (a < 48 || a > 57) {
					answer = false;
				}
			}
			return answer;
		} else {
			System.out.println(s.length()+"���� �Դϴ�");
			System.out.println("1 ~ 8�� �� �־��ּ���");
			return false;
		}
	}

	public static void main(String[] args) {
		BasicOfString bos = new BasicOfString();
		System.out.println(bos.solution("13456a78"));
	}
}

/* ���α׷��ӽ� ä�� + 11������
class Solution {
	  public boolean solution(String s) {
	      boolean answer = true;
	      char[] charr = {};
	      String string = s;
	      if (s.length() == 4 || s.length() == 6) {
	      if (s.length() > 0 && s.length() < 9) {
	          charr = string.toCharArray();
	          for(int i = 0; i < string.length(); i++) {
	              int a = charr[i];
	              if(a < 48 || a > 57) {
	                  answer = false;
	              }
	          }        
	      }
	          return answer;
	      }
	      return false;
	  }
	}
*/