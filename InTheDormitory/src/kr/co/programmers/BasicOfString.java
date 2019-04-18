package kr.co.programmers;

//문자열 s의 길이가 4 혹은 6이고,
//숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
//예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
//
//제한 사항
//s는 길이 1 이상, 길이 8 이하인 문자열입니다.

public class BasicOfString {
// 일단 문자열의 수를 알아야함
// 그리고 숫자인지 문자인지를 알아야함, 모두 숫자여야 True
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
			System.out.println(s.length()+"글자 입니다");
			System.out.println("1 ~ 8자 를 넣어주세요");
			return false;
		}
	}

	public static void main(String[] args) {
		BasicOfString bos = new BasicOfString();
		System.out.println(bos.solution("13456a78"));
	}
}

/* 프로그래머스 채점 + 11점나옴
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