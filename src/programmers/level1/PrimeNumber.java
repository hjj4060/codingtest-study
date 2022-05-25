package programmers.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        System.out.println(solution(N));

    }

    static private int solution(int n) {
        int answer = 0;

        /* brute force
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            cnt = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                    if(cnt > 1) break;
                }
            }
            if(cnt == 1) answer++;
        }
        */

        boolean arr[] = new boolean[n+1];

        for (int i = 2; i < n; i++) {
            if (arr[i] == true) continue;


        }

        return answer;
    }
}



