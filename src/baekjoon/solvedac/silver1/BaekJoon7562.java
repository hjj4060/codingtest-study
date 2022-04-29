package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7562 나이트의이동
public class BaekJoon7562 {
    static StringBuilder sb = new StringBuilder();

    static int chessBoard[][];
    static boolean visit[][];
    static Node start, end;

    static Queue<Node> q = new LinkedList<>();
    static int I;
    static int dx[] = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int dy[] = {2, 2, 1, -1, -2, -2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            I = Integer.parseInt(st.nextToken());
            chessBoard = new int[I][I];
            visit = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs();
            q.clear();
        }

        System.out.println(sb);
    }

    private static void bfs() {
        q.add(start);
        visit[start.x][start.y] = true;

        Node n;

        while (!q.isEmpty()) {
            n = q.poll();

            if (n.x == end.x && n.y == end.y) {
                sb.append(chessBoard[n.x][n.y]).append("\n");
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int tx = n.x + dx[i];
                int ty = n.y + dy[i];

                if(tx < 0 || tx >= I || ty < 0 || ty >= I || visit[tx][ty]) continue;

                q.add(new Node(tx, ty));
                chessBoard[tx][ty] = chessBoard[n.x][n.y] + 1;
                visit[tx][ty] = true;
            }
        }
    }

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
