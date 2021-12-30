package baekjoon.stepbystep.basic_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1978
public class FindPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int num, cnt = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            boolean sosu = true;

            if(num != 1) {
                for (int j = 2; j < num; j++) {
                    if(num % j == 0) {
                        sosu = false;
                        break;
                    }
                }
                if (sosu) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
