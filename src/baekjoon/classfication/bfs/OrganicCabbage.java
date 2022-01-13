package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1012
public class OrganicCabbage {
    static int M; //가로
    static int N; //세로
    static int K; //배추 위치 개수
    static int cabbage[][]; //배추 위치
    static boolean visit[][]; //방문 여부
    static int larvaCnt = 0;

    static Queue<Node> q = new LinkedList<>();
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int T = scan.nextInt();

        for(int ii=0; ii<T; ii++) {
            larvaCnt = 0;

            M = scan.nextInt(); //가로
            N = scan.nextInt(); //세로
            K = scan.nextInt();

            cabbage = new int[N][M]; //세로 가로
            visit = new boolean[N][M];

            int x, y;

            for (int i = 0; i < K; i++) {
                x = scan.nextInt(); //가로
                y = scan.nextInt(); // 세로

                cabbage[y][x] = 1;
            }

            BFS();

            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    result = Math.max(result, cabbage[i][j]);
                }
            }

            System.out.println(result);
        }

    }

    private static void BFS() {
        Node n;

        //cabage[][]에서 1을 찾는다.
        while(findCabbage()) {
            while(!q.isEmpty()) {
                n = q.poll();

                //동서남북
                for (int i = 0; i < dx.length; i++) {
                    int tx = n.x + dx[i];
                    int ty = n.y + dy[i];

                    if(tx < 0 || ty < 0 || tx >= N || ty >= M || visit[tx][ty] == true || cabbage[tx][ty] == 0) continue;

                    q.add(new Node(tx, ty));
                    visit[tx][ty] = true;

                    cabbage[tx][ty] = larvaCnt;
                }
            }
        }
    }

    static boolean findCabbage() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j] == false && cabbage[i][j] == 1) {
                    larvaCnt++;

                    q.add(new Node(i, j));
                    cabbage[i][j] = larvaCnt;
                    visit[i][j] = true;

                    return true;
                }
            }
        }

        return false;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            if (st == null || !st.hasMoreElements()) {

                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
