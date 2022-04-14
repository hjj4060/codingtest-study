package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2667 단지번호붙이기
public class ApartmentComplexNumbering {
    static int N; //지도의 크기
    static int arr[][];
    static boolean visit[][];
    static int apartNum = 0;

    static int dx[] = new int[]{1, 0, -1, 0};
    static int dy[] = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        input();

        pro();
    }

    static private void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 1 && visit[i][j] == false) {
                    apartNum++;
                    dfs(new Node(i, j)); // 1, 2
                }
            }
        }

        int maxCnt = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(maxCnt > arr[i][j]) continue;

                maxCnt = arr[i][j];
            }
        }

        int result[] = new int[maxCnt];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != 0) {
                    result[arr[i][j] - 1]++;
                }
            }
        }


        StringBuilder sb = new StringBuilder();

        sb.append(maxCnt).append("\n");

        Arrays.sort(result);

        for (int i:result) {
            sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    static private void dfs(Node node) {
        int x = node.x; //1
        int y = node.y; //2

        visit[x][y] = true;
        arr[x][y] = apartNum;

        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx < 1 || ty < 1 || tx > N || ty > N || arr[tx][ty] == 0 || visit[tx][ty] ) continue;

            dfs(new Node(tx, ty));
        }
    }

    static private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];

        String complex;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            complex = st.nextToken();

            for (int j = 1; j <= N; j++) {
                arr[i][j] = complex.charAt(j - 1) - '0';
            }
        }
    }

    static private void test() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
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
