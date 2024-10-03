package programmers.level2;

import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class 타겟넘버 {
	static List<List<Integer>> resultList = new ArrayList<>();

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		int[] visit = new int[numbers.length];
		List<Integer> result = new ArrayList<>();

		backtracking(0, numbers, result);

		answer = print(target);

		return answer;
	}

	static int print(int target) {
		int answer = 0;
		for (List<Integer> integers : resultList) {
			int sum = 0;

			for (Integer integer : integers) {
				sum += integer;
			}

			if (target == sum) {
				answer++;
			}
		}

		return answer;
	}

	static void backtracking(int depth, int[] numbers, List<Integer> curList) {
		if (depth == numbers.length) {
			resultList.add(new ArrayList<>(curList));
			return;
		}

		//-와 +
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				curList.add(numbers[depth] * -1);
				backtracking(depth + 1, numbers, curList);
				curList.remove(curList.size() - 1);
			} else {
				curList.add(numbers[depth]);
				backtracking(depth + 1, numbers, curList);
				curList.remove(curList.size() - 1);
			}
		}
	}
}
