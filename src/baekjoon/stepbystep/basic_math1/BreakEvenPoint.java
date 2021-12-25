package baekjoon.stepbystep.basic_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1712
public class BreakEvenPoint {
    private static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int cnt=0;

        while(true) {
            cnt++;
            if (c - b <= 0) {
                System.out.println(-1);
                break;
            } else if (a - ((c - b) * cnt) < 0) {
                System.out.println(cnt);
                break;
            }
        }
    }
}
