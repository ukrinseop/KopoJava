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
		      
		
		
		

	


