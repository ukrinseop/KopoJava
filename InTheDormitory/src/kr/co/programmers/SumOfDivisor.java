package kr.co.programmers;

public class SumOfDivisor { // 190417(��) 15�� �ɸ�

//	1. �ڿ��� n�� �Է¹޾� n�� ����� ��� ���� ���� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
//	2. n�� �� 0 �̻� 3000������ �ڿ����Դϴ�.
//	3. ����� �� #1
//	   12�� ����� 1, 2, 3, 4, 6, 12�Դϴ�. �̸� ��� ���ϸ� 28�Դϴ�.
//	4. ����� �� #2
//	   5�� ����� 1, 5�Դϴ�. �̸� ��� ���ϸ� 6�Դϴ�.

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
