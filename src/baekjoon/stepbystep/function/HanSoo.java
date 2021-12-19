package baekjoon.stepbystep.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1065
public class HanSoo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());

        int n100, n10, n1;
        int cnt = 0;
        for(int i=1; i<=c; i++) {
            if(i<100) cnt++;
            else {
                n100 = i / 100;
                n10 = (i % 100) / 10;
                n1 = i % 100 % 10;

                if ((n100 - n10) == (n10 - n1)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
