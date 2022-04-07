package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2178 미로탐색
public class MazeExploration {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};

    static int X, Y;

    static boolean visit[][];
    static int maze[][];

    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken()) + 1; //도착점 세로 5
        X = Integer.parseInt(st.nextToken()) + 1; //도착점 가로 7

        visit = new boolean[Y][X];
        maze = new int[Y][X];

        for (int i = 1; i < maze.length; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < s.length(); j++) {
                maze[i][j + 1] = s.charAt(j) - '0';
            }
        }

        //test();

        visit[1][1] = true;
        q.add(new Node(1,1));

        BFS();
        //System.out.println();

        //test();
        //System.out.println();
        System.out.println(maze[Y - 1][X - 1]);
    }

    private static void BFS() {
        Node n;

        while(!q.isEmpty()) {
            n = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = n.x + dx[i]; //2
                int ty = n.y + dy[i]; //1

                if (tx < 1 || ty < 1 || tx >= X || ty >= Y || maze[ty][tx] == 0 || visit[ty][tx] == true) {
                    continue;
                }

                q.add(new Node(tx, ty));
                visit[ty][tx] = true;

                maze[ty][tx] = maze[n.y][n.x] + 1;
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

    private static void test() {
        for (int i = 1; i < maze.length; i++) {
            for (int j = 1; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}