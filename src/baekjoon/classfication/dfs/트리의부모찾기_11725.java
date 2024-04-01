package baekjoon.classfication.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11725
public class 트리의부모찾기_11725 {

	/**
	 * 1부터 연결돼있는걸 찾고 찾은 거에 부모는 1
	 * 자식에서 찾은 거에서 부모를 제외한걸 찾아서 그 찾은수의 부모
	 *
	 * 자료구조 연결리스트
	 * 인접 리스트 ArrayList<Integer> adjList
	 * 방문체크 boolean[] isVisited
	 * 각 노드에 대한 부모 값을 넣는 int[] parent
	 */
	static int nodeCnt;
	static HashMap<Integer, ArrayList<Integer>> adjListMap = new HashMap<>();
	static boolean[] isVisited;
	static int[] parentValueArr;

	static private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nodeCnt = Integer.parseInt(st.nextToken());
		isVisited = new boolean[nodeCnt + 1];
		parentValueArr = new int[nodeCnt + 1];

		//node 1부터 nodeCnt까지 map 초기화
		for (int i = 1; i <= nodeCnt; i++) {
			adjListMap.put(i, new ArrayList<>());
		}

		for (int i = 1; i < nodeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			//양방향 설정
			adjListMap.get(node).add(node2);
			adjListMap.get(node2).add(node);
		}

		for (int i = 1; i <= nodeCnt; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < adjListMap.get(i).size(); j++) {
				System.out.print(adjListMap.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
		print();
	}

	private static void print() {
		for (int i = 2; i < parentValueArr.length; i++) {
			System.out.println(parentValueArr[i]);
		}
	}

	private static void solve() {
		dfs(1);
	}

	private static void dfs(int visitNode) {
		isVisited[visitNode] = true;

		for (int node : adjListMap.get(visitNode)) {
			if (!isVisited[node]) {
				parentValueArr[node] = visitNode;

				dfs(node);
			}
		}
	}
}