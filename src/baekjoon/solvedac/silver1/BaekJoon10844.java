package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10844 쉬운계단수
public class BaekJoon10844 {
    static int dp[][];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][10];

        dp();


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int result = 0;

        for (int j = 1; j <= 9; j++) {
            result += dp[N][j];
        }
        System.out.println(result);
    }

    private static void dp() {
        //[1] 초기화
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }
        if(N == 1) return;

        //[2] 초기화
        for (int j = 1; j <= 9; j++) {
            if (j == 9) {
                dp[2][j] = 1;
            } else {
                dp[2][j] = 2;
            }
        }
        if(N == 2) return;

        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j]) % 1000000000;
            }
        }
    }
}
