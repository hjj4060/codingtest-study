package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2475
public class NumberOfVerifications {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n[] = new int[5];

        for (int i = 0; i < 5; i++) {
           n[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < n.length; i++) {
            result += Math.pow(n[i], 2);
        }

        System.out.println(result % 10);
    }
}
