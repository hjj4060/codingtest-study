package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11720
public class SumOfNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();

        int sum = 0;

        char c[] = a.toCharArray();

        for(int i=0; i<n; i++) {
            sum += c[i] - '0';
        }
        System.out.println(sum);
    }
}
