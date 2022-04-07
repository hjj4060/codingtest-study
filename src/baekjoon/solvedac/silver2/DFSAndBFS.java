package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1260 DFS와 BFS
public class DFSAndBFS {
    static boolean visit[];
    //static ArrayList<Integer>[] adj;
    static int adj[][];
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점개수
        M = Integer.parseInt(st.nextToken()); //간선개수
        V = Integer.parseInt(st.nextToken()); //시작정점

        adj = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            adj[x][y] = 1;
            adj[y][x] = 1;
        }

        dfs(V);

        sb.append("\n");
        for (int i = 1; i <= N; i++) visit[i] = false;

        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(" ");

        for (int y = 1; y <= N; y++) {
            if(adj[x][y] == 0 || visit[y] == true) continue;

            dfs(y);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int x = que.poll();

            sb.append(x).append(" ");
            for (int y = 1; y <= N; y++) {
                if(adj[x][y] == 0 || visit[y] == true) continue;

                que.add(y);
                visit[y] = true;
            }
        }
    }
}
