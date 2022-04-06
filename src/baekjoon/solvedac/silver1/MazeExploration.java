package baekjoon.solvedac.silver1;

import baekjoon.classfication.bfs.Tomato;

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

    static final int X = 0;
    static final int Y = 0;

    static Boolean visit[][];
    static int maze[][];

    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Y = Integer.parseInt(st.nextToken()) + 1; //도착점 세로 5
        int X = Integer.parseInt(st.nextToken()) + 1; //도착점 가로 7

        visit = new Boolean[Y][X];
        maze = new int[Y][X];

        for (int i = 1; i < maze.length; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < s.length(); j++) {
                maze[i][j + 1] = s.charAt(j) - '0';
            }
        }

        test();

        visit[1][1] = true;
        q.add(new Node(1,1));

        BFS();
        System.out.println();

        test();

    }


    private static void BFS() {
        Node n;

        while(!q.isEmpty()) {
            n = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = n.x + dx[i];
                int ty = n.y + dy[i];

                if(tx < 0 || ty < 0 || tx>=X || ty >= Y || maze[tx][ty] == 0 || visit[tx][ty] == true) continue;

                q.add(new Node(tx, ty));
                visit[tx][ty] = true;

                maze[tx][ty] = maze[n.x][n.y] + 1;
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
