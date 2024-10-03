package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS와DFS_2 {
	static int[][] nodeArr;
	static boolean[] visit;
	static int nodeCnt;
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		nodeCnt = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());

		nodeArr = new int[nodeCnt + 1][nodeCnt + 1];
		visit = new boolean[nodeCnt + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodeArr[x][y] = 1;
			nodeArr[y][x] = 1;
		}

		bfs(startNode);

		System.out.println(result);
	}

	static void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);
		visit[startNode] = true;
		result.add(startNode);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.println(node);
			for (int i = 1; i <= nodeCnt; i++) {
				if (nodeArr[node][i] == 1 && !visit[i]) {
					queue.add(i);
					visit[i] = true;
					result.add(i);
				}
			}
		}
	}
}
