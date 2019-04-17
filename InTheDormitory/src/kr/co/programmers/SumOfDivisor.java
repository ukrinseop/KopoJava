package kr.co.programmers;

public class SumOfDivisor { // 190417(수) 15분 걸림

//	1. 자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
//	2. n은 은 0 이상 3000이하인 자연수입니다.
//	3. 입출력 예 #1
//	   12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.
//	4. 입출력 예 #2
//	   5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.

	public int solution(int n) {

		int sum = 0;

		if (n >= 0 && n <= 3000) {
			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					sum += i;
				}
			}
		}
		int answer = sum;
		return answer;
	}

	public static void main(String[] args) {
		SumOfDivisor sod = new SumOfDivisor();
		System.out.println(sod.solution(3001));
		;

	}

}
