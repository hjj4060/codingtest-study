package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7576 토마토
public class Tomato {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int tomato[][];
    static boolean visit[][];
    static Queue<Node> q = new LinkedList<>();

    static int M, N;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());

                if(tomato[i][j] == 1) {
                    q.add(new Node(i, j));
                    visit[i][j] = true;
                }
            }
        }

        BFS();

        flag: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomato[i][j] == 0) {
                    answer = -1;
                    break flag;
                } else {
                   if( tomato[i][j] > answer) answer = tomato[i][j];
                }
            }
        }

        if(answer != -1) System.out.println(answer -1);
        else System.out.println(-1);
    }

    private static void BFS() {
        Node n;

        while(!q.isEmpty()) {
            n = q.poll();

            for(int i=0; i<dx.length; i++) {
                int tx = n.x + dx[i];
                int ty = n.y + dy[i];

                if(tx < 0 || ty < 0 || tx>=N || ty >= M || tomato[tx][ty] == -1 || visit[tx][ty] == true) continue;

                q.add(new Node(tx, ty));
                visit[tx][ty] = true;

                tomato[tx][ty] = tomato[n.x][n.y] + 1;
            }
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
