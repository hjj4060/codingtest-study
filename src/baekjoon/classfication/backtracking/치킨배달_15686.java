package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15686
public class 치킨배달_15686 {
	//N: 지도 크기, M 치킨집 수
	static int N, M;
	static int[][] map;
	static boolean[][] isVisited;

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		isVisited = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// for (int i = 1; i <= N; i++) {
		// 	for (int j = 1; j <= N; j++) {
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
	}

	public static void main(String[] args) throws IOException {
		input();

		solve();
	}

	private static void solve() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 2 && !isVisited[i][j]) {
					isVisited[i][j] = true;
					recur(0);
				}
			}
		}
	}

	private static void recur(int depth) {
		if (depth == M) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 2 && !isVisited[i][j]) {
					isVisited[i][j] = true;
					recur(depth + 1);
					isVisited[i][j] = false;
				}
			}
		}
	}
}

