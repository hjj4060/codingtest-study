package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15686
public class 치킨배달_15686 {
	/**
	 * 풀이방법.
	 * 1. 치킨집 좌료 위치와 집의 위치를 담을 리스트를 따로 만든다.
	 * 2. 치킨집을 M만큼 선택하면 각 집의 위치에서 최단거리의 치킨집의 거리를 모두 더하고 리스트에 담는다.
	 */

	//N: 지도 크기, M 치킨집 수
	static int N, M;
	static ArrayList<int[]> homeList = new ArrayList<int[]>();
	static ArrayList<int[]> chickenList = new ArrayList<int[]>();
	static boolean[] selectCheckin;
	static ArrayList<Integer> sumDistanceList = new ArrayList<>();

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int type = Integer.parseInt(st.nextToken());
				if (1 == type) {
					homeList.add(new int[] {i, j});
				} else if (2 == type) {
					chickenList.add(new int[] {i, j});
				}
			}
		}
		selectCheckin = new boolean[chickenList.size()];
	}

	public static void main(String[] args) throws IOException {
		input();

		solve();

		print();
	}

	private static void print() {
		Integer min = sumDistanceList.stream().min(Comparator.naturalOrder()).orElse(null);
		System.out.println(min);
	}

	private static void solve() {
		recur(0, 0);
	}

	private static void recur(int depth, int idx) {
		if (depth == M) {
			//각 집마다 가장 가까운 치킨거리의 합
			int sumMinDistance = 0;

			for (int i = 0; i < homeList.size(); i++) {
				int minDistance = Integer.MAX_VALUE;

				//치킨집중 거리가 가장 최소인 값을 구해야됨
				for (int j = 0; j < chickenList.size(); j++) {

					if (selectCheckin[j]) {
						int distance = Math.abs(homeList.get(i)[0] - chickenList.get(j)[0]) +
							Math.abs(homeList.get(i)[1] - chickenList.get(j)[1]);

						minDistance = Math.min(minDistance, distance);
					}

				}

				sumMinDistance += minDistance;
			}
			sumDistanceList.add(sumMinDistance);

			return;
		}

		for (int i = idx; i < chickenList.size(); i++) {
			if (!selectCheckin[i]) {
				selectCheckin[i] = true;
				recur(depth + 1, i + 1);
				selectCheckin[i] = false;
			}
		}
	}
}

