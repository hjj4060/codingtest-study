package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1012
public class OrganicCabbage {
    static int M; //가로
    static int N; //세로
    static int K; //배추 위치 개수
    static int cabbage[][]; //배추 위치
    static boolean visit[][]; //방문 여부
    static int result = 0;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int T = scan.nextInt();

        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();

        cabbage = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            cabbage[x][y] = 1;
        }

        BFS();
    }

    private static void BFS() {

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
            if(st==null || !st.hasMoreElements()) {

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
