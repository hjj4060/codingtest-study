package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14889
public class 스타트와링크_14889 {
    static int N;
    static int[][] map;
    static boolean[] isVisited;
    static int[] result;
    static int min = Integer.MAX_VALUE;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        result = new int[N / 2];
        isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        solve();

        print();
    }

    private static void print() {
        System.out.println(min);
    }

    private static void solve() {
        recur(0, 1);

    }

    private static void diff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isVisited[i] && isVisited[j]) {
                    startTeam += map[i][j];
                    startTeam += map[j][i];
                }
                if (!isVisited[i] && !isVisited[j]) {
                    linkTeam += map[i][j];
                    linkTeam += map[j][i];
                }
            }
        }

        int diff = Math.abs(startTeam - linkTeam);
        min = Math.min(diff, min);
    }

    private static void recur(int depth, int start) {
        if(depth == N/2) {
            diff();

            return;
        }

        for (int i = start; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = i;
                recur(depth + 1, i + 1);
                isVisited[i] = false;
            }
        }
    }
}