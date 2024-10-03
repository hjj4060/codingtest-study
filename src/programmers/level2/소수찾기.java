package programmers.level2;

import java.util.HashSet;
import java.util.Set;

//https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class 소수찾기 {
	static Set<Integer> resultList = new HashSet<>();
	static StringBuilder result = new StringBuilder();
	static boolean[] visit;

	public static void main(String[] args) {
		소수찾기 sol = new 소수찾기();
		String numbers1 = "00000000";

		System.out.println(sol.solution(numbers1));
	}

	public int solution(String numbers) {
		int answer = 0;
		visit = new boolean[numbers.length()];

		//1자리 부터 numbers 길이 수 까지 모든 조합을 만들기.
		for (int i = 1; i <= numbers.length(); i++) {
			backtracking(0, i, numbers);
		}

		//resultList 조합의 모든 수를 더해서 소수면 answer count +1
		for (int result : resultList) {
			answer = answer + decimalDetermine(result);

		}

		return answer;
	}

	int decimalDetermine(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return 0;
			}
		}

		return 1;
	}

	public void backtracking(int depth, int digit, String numbers) {
		if (depth == digit) {
			int resultInt = Integer.parseInt(result.toString());
			if (resultInt > 1) {
				resultList.add(resultInt);
			}

			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				result.append(numbers.charAt(i));
				backtracking(depth + 1, digit, numbers);
				visit[i] = false;
				result.deleteCharAt(result.length() - 1);
			}
		}
	}
}
