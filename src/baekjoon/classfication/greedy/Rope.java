package baekjoon.classfication.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2217
public class Rope {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int ropes[] = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ropes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ropes);

        int result = ropes[N - 1];

        for (int i = 0; i < ropes.length; i++) {
            result = Math.max(result, ropes[i] * (N - i));
        }

        System.out.println(result);
    }
}
