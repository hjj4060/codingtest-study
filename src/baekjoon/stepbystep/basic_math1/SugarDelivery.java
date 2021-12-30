package baekjoon.stepbystep.basic_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2839
public class SugarDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while(true) {
            if(N%5 == 0) {
                cnt = cnt + N / 5;
                System.out.println(cnt);
                break;
            } else {
                N -= 3;
                cnt++;
            }

            if(N<0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
