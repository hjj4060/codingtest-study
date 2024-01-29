package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2606
public class 바이러스 {
    /**
     * 1. 아이디어
     *  - 1번 컴퓨터가 방문할수있는 컴퓨터의 개수를 카운트
     *
     * 2. 시간복잡도
     *  - 컴퓨터수 100 이하  100 * 100 = 10000
     *
     * 3. 변수
     *  - visit[] 1번 컴퓨터에서 어느 컴퓨터로 갔는지 방문체크
     *  - adj[][] 인접행렬
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] adj;
    static boolean[] isVisited;
    static int computerCnt, edgeCnt;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        computerCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        edgeCnt = Integer.parseInt(st.nextToken());

        adj = new int[computerCnt + 1][computerCnt + 1];
        isVisited = new boolean[computerCnt + 1];

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }
    public static void main(String[] args) throws IOException {
        input();

        solve();
    }

    private static void solve() {
        System.out.println(bfs(1));
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        int computerVirusCnt = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int y = 2; y <= computerCnt; y++) {
                if (adj[x][y] == 1 && !isVisited[y]) {
                    queue.add(y);
                    isVisited[y] = true;
                    computerVirusCnt++;
                }
            }
        }
        return computerVirusCnt;
    }
}
