package baekjoon.classfication.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10810
public class 공넣기_10810 {
	static int[] basket;
	static int ballCnt;
	static ArrayList<int[]> inputBall = new ArrayList<>();

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		basket = new int[N + 1];
		ballCnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < ballCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ballNum = Integer.parseInt(st.nextToken());

			inputBall.add(new int[] {start, end, ballNum});
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
		print();
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < basket.length; i++) {
			sb.append(basket[i]).append(" ");
		}

		System.out.println(sb.toString());
	}

	private static void solve() {
		for (int[] ball : inputBall) {
			int start = ball[0];
			int end = ball[1];
			int ballNum = ball[2];

			for (int i = start; i <= end; i++) {
				basket[i] = ballNum;
			}
		}
	}
}
