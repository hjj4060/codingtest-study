package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11053 가장 긴 증가하는 부분 수열
/*  j     i
    2 1 0 3 0 3
dp  1 1 1 2 1 1
    nums[j] < nums[i]
    dp[i] = dp[j]+1
 */
public class LongestIncreasingSubsequence {
    static int A[];
    static int N;
    static int B[];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        input();

        test();

        pro();
        System.out.println();

        test();

        Arrays.sort(B);
        result = B[N] + 1;
        System.out.println();

        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //6

        A = new int[N + 1];
        B = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() {
        int temp = 0;

        for (int i = 1; i <= N; i++) {
            temp = A[i];
            for (int j = i + 1; j <= N; j++) {
                if (A[i] < A[j] && temp < A[j]) {
                    B[i]++;
                    temp = A[j];
                }
            }
        }
    }

    private static void test() {
        for (int i = 1; i <= N; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();

        for (int i = 1; i <= N; i++) {
            System.out.print(B[i] + " ");
        }
        System.out.println();
    }
}
