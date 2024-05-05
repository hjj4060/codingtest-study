package baekjoon.classfication.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10811
public class 바구니뒤집기_10811 {
	static ArrayList<int[]> methodList = new ArrayList<int[]>();
	static int[] basket;

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int basketCnt = Integer.parseInt(st.nextToken());
		int methodCnt = Integer.parseInt(st.nextToken());
		basket = new int[basketCnt + 1];

		for (int i = 1; i <= basketCnt; i++) {
			basket[i] = i;
		}

		for (int i = 0; i < methodCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			methodList.add(new int[] {start, end});
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
		print();
	}

	private static void print() {
		for (int i = 1; i < basket.length; i++) {
			System.out.print(basket[i] + " ");
		}
	}

	private static void solve() {
		for (int[] method : methodList) {
			int start = method[0];
			int end = method[1];

			while (start < end) {
				int tmp = basket[start];
				basket[start] = basket[end];
				basket[end] = tmp;
				start++;
				end--;
			}
		}
	}
}
