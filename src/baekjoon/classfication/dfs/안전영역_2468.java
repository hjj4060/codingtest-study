package baekjoon.classfication.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2468
public class 안전영역_2468 {

	static int N;
	static int maxHeight;
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int maxSafeArea = 0;

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int height = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, height);
				map[i][j] = height;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();

		solve();

		print();
	}

	private static void print() {
		System.out.println(maxSafeArea);
	}

	private static void solve() {
		if (maxHeight == 1) {
			maxSafeArea = 1;
			return;
		}

		for (int k = 1; k < maxHeight; k++) {
			int safeArea = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > k && !isVisited[i][j]) {
						isVisited[i][j] = true;

						safeArea++;
						dfs(i, j, k);
					}
				}
			}
			maxSafeArea = Math.max(safeArea, maxSafeArea);
			resetIsVisited();
		}
	}

	private static void dfs(int y, int x, int maxHeight) {
		for (int i = 0; i < 4; i++) {
			int qy = y + dy[i];
			int qx = x + dx[i];

			if (qy >= 0 && qy < N && qx >= 0 && qx < N && !isVisited[qy][qx] && map[qy][qx] > maxHeight) {
				isVisited[qy][qx] = true;
				dfs(qy, qx, maxHeight);
			}
		}
	}

	private static void resetIsVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				isVisited[i][j] = false;
			}
		}
	}
}
