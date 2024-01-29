package baekjoon.classfication.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS와DBS {
    static int N,M, V;
    static int[][] adj;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    private static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); //정점개수
        M = scan.nextInt(); //간선개수
        V = scan.nextInt(); //탐색 시작 정점

        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    public static void main(String[] args) {
        input();
        System.out.println();
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        solve();

        System.out.println(sb.toString());

    }

    private static void solve() {
        visit = new boolean[N + 1];
        bfs(V);
        //dfs(V);
    }

    private static void dfs(int x) {

    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int x = que.poll();
            sb.append(x).append(" ");

            for (int y = 1; y <= N; y++) {
                if(adj[x][y] == 1 && !visit[y]) {
                    que.add(y);
                    visit[y] = true;
                }
            }

        }
    }
}
