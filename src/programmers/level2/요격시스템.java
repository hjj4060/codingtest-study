package programmers.level2;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/181188
public class 요격시스템 {
	public static void main(String[] args) {
		int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

		System.out.println(solution(targets));
	}

	public static int solution(int[][] targets) {
		int answer = 0;

		Arrays.sort(targets, ((x, y) -> x[0] - y[0]));

		int preStart = targets[0][0];
		int preEnd = targets[0][1];

		return 0;
	}
}