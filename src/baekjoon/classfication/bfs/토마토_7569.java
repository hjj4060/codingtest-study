package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7569
public class 토마토_7569 {
	/**
	 * 아이디어
	 * 1. 3차 for문을 돌아서 1인걸 찾아서 bfs() 실행시킨다.
	 * 2. 토마토 상자의 값이 0 인데 방문체크가 false면 -1을 리턴한다.
	 * 3. 토마토 익은 날짜를 담는 배열을 하나 만들어서 정답을 출력한다.
	 * 4. 큐를 돌아서 방문할때마다 큐의 x,y,z의 값 + 1 한 값을 tomatoRipeDay 에 담는다.
	 * 5. tomatoRipeDay에서 가장 큰 값을 출력한다.
	 *
	 * 자료구조
	 * - 토마토 상자 : int[z][y][x] map
	 * - 토마토가 익은 날짜 : int[z][y][x] tomatoRipeDay
	 * - 방문 체크 : boolean[z][y][x] isVisited
	 * - 가로이동 : int[] = new int[]{0, 1, 0, -1, 0, 0}
	 * - 세로이동 : int[] = new int[]{1, 0, -1, 0, 0, 0}
	 * - 위아래이동 : int[] = new int[]{0, 0, 0, 0, 1, -1}
	 */

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	static int[][][] map = null;
	static int[][][] tomatoRipeDay = null;
	static boolean[][][] isVisited = null;
	static int mapZ, mapY, mapX;
	static Queue<int[]> queue = new LinkedList<>();

	static int[] dx = new int[] {0, 1, 0, -1, 0, 0};
	static int[] dy = new int[] {1, 0, -1, 0, 0, 0};
	static int[] dz = new int[] {0, 0, 0, 0, 1, -1};

	private static void input() throws Exception {
		//가로x, 세로y, 상자높이 z입력
		st = new StringTokenizer(br.readLine());
		mapX = Integer.parseInt(st.nextToken());
		mapY = Integer.parseInt(st.nextToken());
		mapZ = Integer.parseInt(st.nextToken());

		map = new int[mapZ][mapY][mapX];
		tomatoRipeDay = new int[mapZ][mapY][mapX];
		isVisited = new boolean[mapZ][mapY][mapX];

		//z, y, x 3중 for문 한줄 마다 map에 인입
		for (int i = 0; i < mapZ; i++) {
			for (int j = 0; j < mapY; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < mapX; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		// for (int i = 0; i < mapZ; i++) {
		// 	for (int j = 0; j < mapY; j++) {
		// 		for (int k = 0; k < mapX; k++) {
		// 			System.out.print(map[i][j][k] + " ");
		// 		}
		// 		System.out.println();
		// 	}
		// }
	}

	public static void main(String[] args) throws Exception {
		input();

		solve();

		// for (int i = 0; i < mapZ; i++) {
		// 	for (int j = 0; j < mapY; j++) {
		// 		for (int k = 0; k < mapX; k++) {
		// 			System.out.print(tomatoRipeDay[i][j][k] + " ");
		// 		}
		// 		System.out.println();
		// 	}
		// }

		print();
	}

	private static void print() {
		//토마토 상자의 값이 0 인데 방문체크가 false면 -1을 리턴한다.
		for (int i = 0; i < mapZ; i++) {
			for (int j = 0; j < mapY; j++) {
				for (int k = 0; k < mapX; k++) {
					if (map[i][j][k] == 0 && !isVisited[i][j][k]) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		int answer = 0;
		//tomatoRipeDay에서 가장 큰 값을 출력한다.
		for (int i = 0; i < mapZ; i++) {
			for (int j = 0; j < mapY; j++) {
				for (int k = 0; k < mapX; k++) {
					answer = Math.max(tomatoRipeDay[i][j][k], answer);
				}
			}
		}
		System.out.println(answer);
	}

	private static void solve() {
		for (int i = 0; i < mapZ; i++) {
			for (int j = 0; j < mapY; j++) {
				for (int k = 0; k < mapX; k++) {
					if (map[i][j][k] == 1 && !isVisited[i][j][k]) {
						isVisited[i][j][k] = true;
						queue.add(new int[] {i, j, k});
					}
				}
			}
		}

		bfs();
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] curZYX = queue.poll();
			int curZ = curZYX[0];
			int curY = curZYX[1];
			int curX = curZYX[2];
			int curDay = tomatoRipeDay[curZ][curY][curX];

			for (int i = 0; i < dx.length; i++) {
				int qz = curZ + dz[i];
				int qy = curY + dy[i];
				int qx = curX + dx[i];

				if (qz >= 0 && qz < mapZ && qy >= 0 && qy < mapY && qx >= 0 && qx < mapX
					&& map[qz][qy][qx] == 0 && !isVisited[qz][qy][qx]) {

					isVisited[qz][qy][qx] = true;
					tomatoRipeDay[qz][qy][qx] = curDay + 1;
					queue.add(new int[] {qz, qy, qx});
				}
			}
		}
	}
}
