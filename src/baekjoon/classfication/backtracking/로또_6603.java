package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/6603
public class 로또_6603 {
	static int S, K;
	static ArrayList<int[]> inputList = new ArrayList<>();
	static boolean[] isVisited;
	static int[] result;
	static ArrayList<int[]> resultList = new ArrayList<>();
	static int[] tmpArr;

	static private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new int[6];

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());

			if (S == 0) {
				break;
			} else {
				int[] input = new int[S + 1];
				input[0] = S;
				isVisited = new boolean[S + 1];

				for (int i = 1; i <= S; i++) {
					input[i] = Integer.parseInt(st.nextToken());
				}
				inputList.add(input);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();

		solve();
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();

		for (int[] result : resultList) {
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void solve() {
		for (int i = 0; i < inputList.size(); i++) {
			tmpArr = inputList.get(i).clone();
			K = tmpArr[0];

			for (int j = 1; j <= 6; j++) {
				isVisited[j] = false;
			}

			recur(1, 0);

			print();
			resultList.clear();
		}
	}

	private static void recur(int start, int depth) {
		if (depth == 6) {
			resultList.add(result.clone());
			return;
		}
		for (int i = start; i <= K; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				result[depth] = tmpArr[i];
				recur(i + 1, depth + 1);
				isVisited[i] = false;
			}
		}
	}
}