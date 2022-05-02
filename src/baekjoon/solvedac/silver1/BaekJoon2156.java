package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2156 포도주 시식
public class BaekJoon2156 {
    static int N;
    static int wine[];
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        wine = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            wine[i] = Integer.parseInt(st.nextToken());
        }

        dp();

        System.out.println(dp[N - 1]);
    }
    private static void dp() {
        dp[0] = wine[0];
        if (N > 1) {
            dp[1] = wine[0] + wine[1];
        }

        if (N > 2) {
            dp[2] = Math.max(Math.max(dp[1], dp[0] + wine[2]), wine[1] + wine[2]);

            for (int i = 3; i < N; i++) {
                if (i == 3) {
                    dp[i] = Math.max(Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]), wine[i - 2] + wine[i - 1]);
                } else {
                    dp[i] = Math.max(Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]), dp[i - 4] + wine[i - 2] + wine[i - 1]);
                }
            }
        }
    }
}
