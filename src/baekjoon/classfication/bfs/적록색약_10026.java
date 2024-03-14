package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10026
public class 적록색약_10026 {
	/**
	 * 아이디어
	 * 1. for문을 돌아서 isVisited가 false면 bfs실행
	 * 2. 일반 사람 map과 색약 map을 따로 만들어서 각각 bfs를 돌린다.
	 * 3. 각 BFS가 실행되는 값이 정답
	 */

	static int N;

	static char[][] normalMap;
	static char[][] blindMap;
	static boolean[][] isNormalVisited;
	static boolean[][] isBlindVisited;
	static int normalAnswer;
	static int blindAnswer;

	static int dx[] = {0, -1, 0, 1};
	static int dy[] = {-1, 0, 1, 0};

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		normalMap = new char[N][N];
		blindMap = new char[N][N];
		isNormalVisited = new boolean[N][N];
		isBlindVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String rgb = st.nextToken();

			for (int j = 0; j < N; j++) {
				normalMap[i][j] = rgb.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				blindMap[i][j] = (normalMap[i][j] == 'G') ? 'R' : normalMap[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();

		solve();

		print();
	}

	private static void print() {
		System.out.println(normalAnswer + " " + blindAnswer);
	}

	private static void solve() {
		//일반 사람
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isNormalVisited[i][j]) {
					bfs(i, j, normalMap[i][j], false);
					normalAnswer++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isBlindVisited[i][j]) {
					bfs(i, j, blindMap[i][j], true);
					blindAnswer++;
				}
			}
		}
	}

	//isColorBlindness는 색약 인지 아닌지 구별
	private static void bfs(int y, int x, char color, boolean isColorBlindness) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y, x});

		while (!queue.isEmpty()) {
			int[] curYX = queue.poll();

			for (int i = 0; i < dx.length; i++) {
				int qy = curYX[0] + dy[i];
				int qx = curYX[1] + dx[i];

				if (checkBFS(qy, qx, color, isColorBlindness)) {
					if (!isColorBlindness) {
						isNormalVisited[qy][qx] = true;
					} else {
						isBlindVisited[qy][qx] = true;
					}

					queue.add(new int[] {qy, qx});
				}
			}
		}
	}

	private static boolean checkBFS(int qy, int qx, char color, boolean isColorBlindness) {
		if (qy < 0 || qy >= N || qx < 0 || qx >= N) {
			return false;
		}

		if (!isColorBlindness) {
			if (!isNormalVisited[qy][qx] && normalMap[qy][qx] == color) {
				return true;
			}
		} else {
			if (!isBlindVisited[qy][qx] && blindMap[qy][qx] == color) {
				return true;
			}
		}
		return false;
	}
}
