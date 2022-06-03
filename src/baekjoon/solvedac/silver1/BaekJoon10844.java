package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10844 쉬운계단수
public class BaekJoon10844 {
    static long dp[][];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][10];


        //[1] 초기화
        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }

        if (N >= 2) {
            dp();
        }
/*
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
*/
        long result = 0;

        for (int j = 1; j <= 9; j++) {
            result += dp[N][j] % 1000000000;
        }
        System.out.println(result);
    }

    private static void dp() {
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
    }
}
