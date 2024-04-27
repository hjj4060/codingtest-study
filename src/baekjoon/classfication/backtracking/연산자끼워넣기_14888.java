package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14888
public class 연산자끼워넣기_14888 {
	static int N;
	static int[] inputNums;
	static int result;
	static ArrayList<Integer> resultList = new ArrayList<>();
	static int[] operCnt = new int[4]; //+, -, *, / 순서대로 개수

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		inputNums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputNums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operCnt[i] = Integer.parseInt(st.nextToken());
		}

		result = inputNums[0];
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
		print();
	}

	private static void print() {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (Integer result : resultList) {
			max = Math.max(max, result);
			min = Math.min(min, result);
		}

		System.out.println(max);
		System.out.println(min);
	}

	private static void solve() {
		recur(result, 0);
	}

	private static void recur(int num, int depth) {
		if (depth == N - 1) {
			resultList.add(result);
			result = 0;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operCnt[i] > 0) {
				operCnt[i]--;

				switch (i) {
					case 0:
						result = num + inputNums[depth + 1];
						recur(result, depth + 1);
						break;
					case 1:
						result = num - inputNums[depth + 1];
						recur(result, depth + 1);
						break;
					case 2:
						result = num * inputNums[depth + 1];
						recur(result, depth + 1);
						break;
					case 3:
						result = num / inputNums[depth + 1];
						recur(result, depth + 1);
						break;
				}

				operCnt[i]++;
			}
		}
	}
}
