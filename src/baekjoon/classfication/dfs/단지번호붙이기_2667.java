package baekjoon.classfication.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2667
public class 단지번호붙이기_2667 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	static int N; //지도 크기
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int each = 0;
	static ArrayList<Integer> resultList = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	static private void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
		print();
	}

	private static void print() {
		sb.append(resultList.size()).append("\n");

		Collections.sort(resultList);

		for (int i = 0; i < resultList.size(); i++) {
			sb.append(resultList.get(i)).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !isVisited[i][j]) {
					isVisited[i][j] = true;
					dfs(i, j);

					resultList.add(each);
					each = 0;
				}
			}
		}
	}

	private static void dfs(int y, int x) {
		each++;

		for (int i = 0; i < 4; i++) {
			int qy = y + dy[i];
			int qx = x + dx[i];

			if (qy >= 0 && qy < N && qx >= 0 && qx < N && map[qy][qx] == 1 && !isVisited[qy][qx]) {
				isVisited[qy][qx] = true;
				dfs(qy, qx);
			}
		}
	}

}
