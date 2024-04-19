package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15650
public class N과M_15650 {
	static int N, M;
	static int[] result;
	static boolean[] isVisited;
	static ArrayList<int[]> resultList = new ArrayList<>();

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		isVisited = new boolean[N + 1];
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
		print();
	}

	private static void print() {
		resultList.forEach(arr -> {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		});
	}

	private static void solve() {
		recur(0, 0);
	}

	private static void recur(int start, int depth) {
		if (depth == M) {
			int[] arr = result.clone();
			resultList.add(arr);
			return;
		}
		for (int i = start + 1; i <= N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				result[depth] = i;
				recur(i, depth + 1);
				isVisited[i] = false;
			}
		}
	}
}
