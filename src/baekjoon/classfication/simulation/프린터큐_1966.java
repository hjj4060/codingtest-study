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
	static ArrayList<Integer> importanceList = new ArrayList<>();
	static int findDocument;
	static ArrayList<int[]> printOrder = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
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

				importanceList.add(documentImportance);
				queue.add(doc);
			}

			solve();
			addResult();

			queue.clear();
			importanceList.clear();
			printOrder.clear();
		}

		print();
	}

	private static void print() {
		System.out.println(sb.toString());
	}

	private static void solve() {
		while (!queue.isEmpty()) {
			int[] doc = queue.poll();
			int docImportance = doc[1];
			boolean maxImportance = true;

			for (int i = 0; i < importanceList.size(); i++) {
				if (docImportance < importanceList.get(i)) {
					maxImportance = false;
					break;
				}
			}

			if (!maxImportance) {
				queue.add(doc);
			} else {
				for (int i = 0; i < importanceList.size(); i++) {
					if (docImportance == importanceList.get(i)) {
						importanceList.remove(i);
						break;
					}
				}

				printOrder.add(doc.clone());
			}
		}
	}

	private static void addResult() {
		for (int i = 1; i <= printOrder.size(); i++) {
			if (printOrder.get(i - 1)[0] == findDocument) {
				sb.append(i).append("\n");
				break;
			}
		}
	}
}