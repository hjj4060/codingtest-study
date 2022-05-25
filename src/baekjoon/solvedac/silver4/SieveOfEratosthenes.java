package baekjoon.solvedac.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2960 에라토스테네스의 체
public class SieveOfEratosthenes {
    static boolean arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = sieveOfEratosthenes(N, K);

        System.out.println(result);
    }

    private static int sieveOfEratosthenes(int N, int K) {
        arr = new boolean[N + 1];

        arr[0] = true;
        arr[1] = true;

        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            if(arr[i]) continue;
            cnt++;

            if(cnt == K) {
                return i;
            }

            for (int j = i + i; j <= N; j += i) {
                if(arr[j]) continue;

                arr[j] = true;
                cnt++;
                if(cnt == K) {
                    return j;
                }
            }
        }

        return 0;
    }
}
