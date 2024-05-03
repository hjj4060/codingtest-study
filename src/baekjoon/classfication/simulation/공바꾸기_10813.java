package baekjoon.classfication.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10813
public class 공바꾸기_10813 {
	static int[] basket;
	static ArrayList<int[]> changeBall = new ArrayList<int[]>();

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		basket = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			basket[i] = i;
		}

		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ballNum1 = Integer.parseInt(st.nextToken());
			int ballNum2 = Integer.parseInt(st.nextToken());
			changeBall.add(new int[] {ballNum1, ballNum2});
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
			sb.append(basket[i] + " ");
		}
		System.out.println(sb.toString());
	}

	private static void solve() {
		for (int[] ballLocation : changeBall) {
			int tmpBall = basket[ballLocation[0]];
			basket[ballLocation[0]] = basket[ballLocation[1]];
			basket[ballLocation[1]] = tmpBall;
		}
	}
}
