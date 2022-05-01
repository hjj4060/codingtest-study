package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1149 RGB거리
public class RGBDistance {
    static int house[][];
    static Integer dp[][];
    static int N;

    public static void main(String[] args) throws IOException{
        input();
        dp();

        //test();

        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }

    private static void dp() {
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + house[i][0] , dp[i - 1][2] + house[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + house[i][1] , dp[i - 1][2] + house[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + house[i][2] , dp[i - 1][1] + house[i][2]);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        house = new int[N][3];
        dp = new Integer[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                int n = Integer.parseInt(st.nextToken());
                house[i][j] = n;
                if (i == 0) {
                    dp[i][j] = n;
                }
            }
        }
    }

    private static void test() {
        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(house[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
