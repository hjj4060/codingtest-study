package baekjoon.classfication.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1966
public class 프린터큐_1966 {
	static Queue<int[]> queue = new LinkedList<int[]>();
	static Set<Integer> importanceSet = new HashSet<>();
	static int findDocument;
	static ArrayList<Integer> printOrder = new ArrayList<Integer>();

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());
			int documentCnt = Integer.parseInt(st.nextToken());
			findDocument = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < documentCnt; j++) {
				int documentImportance = Integer.parseInt(st.nextToken());
				int[] doc = new int[] {j, documentImportance};

				importanceSet.add(documentImportance);
				queue.add(doc);
			}

			solve();
			System.out.println();
			queue.clear();
			importanceSet.clear();
			printOrder.clear();
		}
	}

	public static void main(String[] args) throws IOException {
		input();

	}

	private static void solve() {
		//queue를 poll해서 나머지 문서들중 자기보다 중요도가 큰게 있으면 큐의 제일 뒤쪽에 넣기

		while (true) {
			int[] doc = queue.poll();
			int docImportance = doc[1];
			boolean maxImportance = false;

			for (Integer importance : importanceSet) {
				System.out.println(importance);
			}
			break;
		}
	}
}