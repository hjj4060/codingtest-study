package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N과M_15649_2 {
	static int N;
	static int M;
	static int[] result;
	static boolean[] visit;
	static ArrayList<int[]> resultList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[N];
		visit = new boolean[N + 1];

		recur(0);
	}

	public static void recur(int depth) {
		if (depth == M) {
			resultList.add(result.clone());

			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;

				result[depth] = i;
				recur(depth + 1);
				visit[i] = false;
			}
		}
	}
}
